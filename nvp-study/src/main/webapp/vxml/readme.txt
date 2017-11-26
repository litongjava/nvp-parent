方式一
<field name="accountNum">
    <prompt>xx<prompt>
    <grammar src="builtin:grammar/digits?language=en-US;length=7"/>
</filed>
方式二
<field name="accountNum" type="digits?language=en-US;length-7">
    <prompt>xx<prompt>
</filed>
方式三,在语法文件中限制
<rule id="ROOT" scope="public">
    <ruleref uri="builtin:grammar/digits?lanauage=en-US;length=7"/>
    <tag>custnumber=_digits.MEANING</tag>
</rule>


