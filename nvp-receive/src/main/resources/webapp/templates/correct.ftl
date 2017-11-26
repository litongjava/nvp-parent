<#--请求正常返回的vxml模板-->
<#compress>
<?xml version="1.0" encoding="UTF-8"?>
<!--添加vxml约束,必须添加-->
<!DOCTYPE vxml PUBLIC "-//Nuance/DTD VoiceXML 2.0//ZH" "http://voicexml.nuance.com/dtd/nuancevoicexml-2-0.dtd">
<!--指定xml版本-->
<vxml version="2.0">
    <form id="main">
        <block>
			${prompt}<#--北京合光人工智能机器人技术有限公司-->
			<goto next="${desEle}"/>
        </block>
    </form>
</vxml>
</#compress>