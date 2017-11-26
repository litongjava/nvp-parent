package cn.eastrobot.www.ws.RobotServiceEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class TestClient {
	/*public static void main(String[] args) throws Exception {
		RobotServiceEx_Service service = new RobotServiceEx_ServiceLocator();
		RobotServiceEx_PortType client = service.getDefaultRobotServiceExPort();
		String sessionId = "1231231231231";
		String userId = "4564564561123";
		String question = "��ȡ�����";
		String platform = "web";
		RobotRequest robotRequest = new RobotRequest();
		robotRequest.setSessionId(sessionId);
		robotRequest.setUserId(userId);
		robotRequest.setQuestion(question);
		try {
			
			UserAttribute pf = new UserAttribute("platform", platform);
			UserAttribute[] attributes = new UserAttribute[] { pf };
			robotRequest.setAttributes(attributes);
			
			RobotResponse responseEx = client.deliver(robotRequest);
			
			RobotCommand[] rcs =  responseEx.getCommands();
			String url = "";
			
			for(RobotCommand rc : rcs)
			{
				String[] ss = rc.getArgs();
				if(ss!=null){
					System.out.println("lenth  = "+ss.length);
					if(ss.length >= 3){
						url = ss[2];
					}
					for(String s : ss){
						System.out.print(s+"---");
					}	
				}
				
			}
			/*
			String access_token = VXService4Material.getAccessToken();
			Date date = new Date();
			String localUrl = "f:/imgs/" + Long.toString(date.getTime()) +".jpg";
			
			VXService4Material.getRemoteFile(localUrl, url);
			String media_id = VXService4Material.addMaterial( localUrl, access_token, "image/jpeg" );
			List<MaterialArticle> articles = new ArrayList<MaterialArticle>();
			MaterialArticle ma = new MaterialArticle();
			ma.setAuthor("wangzq");
			ma.setContent(responseEx.getContent().trim());
			ma.setContent_source_url("");
			ma.setDigest("");
			ma.setShow_cover_pic("1");
			ma.setThumb_media_id(media_id);
			ma.setTitle(responseEx.getContent().trim());
			articles.add(ma);
			String newsId = VXService4Material.addNews(access_token, articles);
			System.out.println("news Id" + newsId);
			System.out.println(responseEx.getContent());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}*/
	public static String getAnswer(String question) {
		String result = "";
		String imageUrl = null;
		if (question != null && question.length() > 0) {
			RobotServiceEx_PortType service;
			try {
				service = new RobotServiceEx_ServiceLocator().getDefaultRobotServiceExPort();
				String sessionId = "1231231231231";
				String userId = "4564564561123";
				String platform = "weixin";
				RobotRequest robotRequest = new RobotRequest();
				robotRequest.setSessionId(sessionId);
				robotRequest.setUserId(userId);
				robotRequest.setQuestion(question);
				UserAttribute pf = new UserAttribute();
				pf.setName("platform");
				pf.setValue(platform);
				List<UserAttribute> list = new ArrayList<UserAttribute>();
				list.add(pf);
				UserAttribute[] attributes = new UserAttribute[list.size()];
				attributes = list.toArray(attributes);
				robotRequest.setAttributes(attributes);
				RobotResponse responseEx = service.deliver(robotRequest);
				
				if (responseEx != null) {
					RobotCommand[] command = responseEx.getCommands();
					if (command != null) {
						RobotCommand robotCommand = null;
						for (int i = 0; i < command.length; i++) {
							if (i == 0) {
								robotCommand = command[i];
								imageUrl = Arrays.toString(robotCommand.getArgs());
								
								System.out.println(robotCommand.getName() + "," + robotCommand.getState() + ","
										+ Arrays.toString(robotCommand.getArgs()));
							}
						}
						/*
						 * for (RobotCommand robotCommand : command) { imageUrl
						 * = Arrays.toString(robotCommand.getArgs());
						 * System.out.println(robotCommand.getName() + "," +
						 * robotCommand.getState() + "," +
						 * Arrays.toString(robotCommand.getArgs())); }
						 */
					}

					result = responseEx.getContent();
					// ���ֲ�Ϊ�գ�ͼƬ��Ϊ��
					if ((result != null && !"".equals(result)) && (imageUrl != null && !"null".equals(imageUrl))) {
						result = filterResult(result);
						imageUrl = subImageUrlString(imageUrl);
						// System.out.println("imageUrl:" + imageUrl);
						return result + "|" + imageUrl;
						// ����Ϊ�գ�ͼƬ��Ϊ��
					} else if ((imageUrl != null && !"null".equals(imageUrl)) && (result == null || "".equals(result))) {
						imageUrl = subImageUrlString(imageUrl);
						return imageUrl;
						// ͼƬΪ�գ����ֲ�Ϊ��
					} else if (imageUrl == null || "null".equals(imageUrl) && (result != null && !"".equals(result))) {
						result = filterResult(result);
						return result;
					}

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	public static String filterResult(String result) {

		result = result.trim().replace("\n���[link submit=\"N\"]�鿴�����ȵ�����[/link]", "");
		// result = result.trim().replace("<br>",
		// "\n").replace("<br/>",
		// "\n")
		// .replace("\n���[link submit=\"N\"]�鿴�����ȵ�����[/link]",
		// "");
		result = result.replaceAll("<a(.*?)</a>", "");
		int index = result.indexOf("����ܹ�ע�����������");
		if (index > 0) {
			result = result.substring(0, index - 1);
		}
		if (result.startsWith("<HTML>")) {
			result = result.substring(6);
		}
		if (result.endsWith("</HTML>")) {
			result = result.substring(0, result.length() - 7);
		}
		result = result.replaceAll("[link]", "");
		result = result.replaceAll("[/link]", "");
		result = result.replaceAll("[\\[\\]]", "");
		//result = result.replaceAll("U��", "С˰");
		result = result.replaceAll("\n", "</br>");

		return result;
	}

	public static String subImageUrlString(String imageUrl) {

		if (imageUrl.indexOf("CDATA") > -1) {
			String cut = "]]></PicUrl><Url><![";
			int cutlength = cut.length();
			String[] urlArr = imageUrl.split("CDATA");
			for (int i = 0; i < urlArr.length; i++) {
				if (i == 4) {
					urlArr[i] = urlArr[i].substring(1, urlArr[i].length() - cutlength);
					System.out.println("-----imageUrl:" + urlArr[i]);
					return urlArr[i];
				}
			}
		} else {
			System.out.println("imageUrl:" + imageUrl);
			String[] urlArr = imageUrl.split(",");
			for (int i = 0; i < urlArr.length; i++) {
				if (i == 2) {
					urlArr[i] = urlArr[i].substring(0, urlArr[i].length() - 1);
					System.out.println("-----imageUrl:" + urlArr[i]);
					return urlArr[i];
				}
			}

			return imageUrl;
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("sawa");
		System.out.println(getAnswer("1"));
	}

}
