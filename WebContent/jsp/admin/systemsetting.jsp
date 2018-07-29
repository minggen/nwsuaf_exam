<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<% 
	String systemName = (String)application.getAttribute("systemName");
	String systemNote = (String)application.getAttribute("systemNote");
	String time = (String)request.getAttribute("systemTime");
%>
<div class="panel panel-default">
	<div class="panel-header">系统设置</div>
	<div class="panel-body">
		<form class="layui-form" action="system_setInfo" method="post">

			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">系统名称</label>
				<div class="layui-input-block">
					<input type="text" name="systemname"  lay-verify="required"
						placeholder="<%=systemName %>" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">考试须知</label>
				<div class="layui-input-block">
					<textarea name="systemnote" lay-verify="required" placeholder="<%=systemNote %>" class="layui-textarea"></textarea>
				</div>
			</div>
			<!-- 
			
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">阅读考试须知时间</label>
				<div class="layui-input-block">
					<input type="text" name="systemnote" required lay-verify="required"
						placeholder="请输入阅读考试须知时间" class="layui-input">
				</div>
			</div>
			 -->
			
			
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">时区</label>
				<div class="layui-input-block">
					<select name="timezone" style="width:320px;" class="form-control">
                                  <option value="Etc/GMT">(UTC)协调世界时</option>
                                  <option value="Africa/Casablanca">(UTC)卡萨布兰卡</option>
                                  <option value="Atlantic/Reykjavik">(UTC)蒙罗维亚，雷克雅未克</option>
                                  <option value="Europe/London">(UTC)都柏林，爱丁堡，里斯本，伦敦</option>
                                  <option value="Africa/Lagos">(UTC+01:00)中非西部</option>
                                  <option value="Europe/Paris">(UTC+01:00)布鲁塞尔，哥本哈根，马德里，巴黎</option>
                                  <option value="Africa/Windhoek">(UTC+01:00)温得和克</option>
                                  <option value="Europe/Warsaw">(UTC+01:00)萨拉热窝，斯科普里，华沙，萨格勒布</option>
                                  <option value="Europe/Budapest">(UTC+01:00)贝尔格莱德，布拉迪斯拉发，布达佩斯，卢布尔雅那，布拉格</option>
                                  <option value="Europe/Berlin">(UTC+01:00)阿姆斯特丹，柏林，伯尔尼，罗马，斯德哥尔摩，维也纳</option>
                                  <option value="Europe/Istanbul">(UTC+02:00)伊斯坦布尔</option>
                                  <option value="Europe/Kaliningrad">(UTC+02:00)加里宁格勒(RTZ 1)</option>
                                  <option value="Africa/Johannesburg">(UTC+02:00)哈拉雷，比勒陀利亚</option>
                                  <option value="Asia/Damascus">(UTC+02:00)大马士革</option>
                                  <option value="Asia/Amman">(UTC+02:00)安曼</option>
                                  <option value="Africa/Cairo">(UTC+02:00)开罗</option>
                                  <option value="Africa/Tripoli">(UTC+02:00)的黎波里</option>
                                  <option value="Asia/Jerusalem">(UTC+02:00)耶路撒冷</option>
                                  <option value="Asia/Beirut">(UTC+02:00)贝鲁特</option>
                                  <option value="Europe/Kiev">(UTC+02:00)赫尔辛基，基辅，里加，索非亚，塔林，维尔纽斯</option>
                                  <option value="Europe/Bucharest">(UTC+02:00)雅典，布加勒斯特</option>
                                  <option value="Africa/Nairobi">(UTC+03:00)内罗毕</option>
                                  <option value="Asia/Baghdad">(UTC+03:00)巴格达</option>
                                  <option value="Europe/Minsk">(UTC+03:00)明斯克</option>
                                  <option value="Asia/Riyadh">(UTC+03:00)科威特，利雅得</option>
                                  <option value="Europe/Moscow">(UTC+03:00)莫斯科，圣彼得堡，伏尔加格勒(RTZ 2)</option>
                                  <option value="Asia/Tehran">(UTC+03:30)德黑兰</option>
                                  <option value="Europe/Samara">(UTC+04:00)伊热夫斯克，萨马拉(RTZ 3)</option>
                                  <option value="Asia/Yerevan">(UTC+04:00)埃里温</option>
                                  <option value="Asia/Bak">(UTC+04:00)巴库</option>
                                  <option value="Asia/Tbilisi">(UTC+04:00)第比利斯</option>
                                  <option value="Indian/Mauritius">(UTC+04:00)路易港</option>
                                  <option value="Asia/Dubai">(UTC+04:00)阿布扎比，马斯喀特</option>
                                  <option value="Asia/Kabu">(UTC+04:30)喀布尔</option>
                                  <option value="Asia/Karachi">(UTC+05:00)伊斯兰堡，卡拉奇</option>
                                  <option value="Asia/Yekaterinburg">(UTC+05:00)叶卡捷琳堡(RTZ 4)</option>
                                  <option value="Asia/Tashkent">(UTC+05:00)阿什哈巴德，塔什干</option>
                                  <option value="Asia/Colombo">(UTC+05:30)斯里加亚渥登普拉</option>
                                  <option value="Asia/Calcutta">(UTC+05:30)钦奈，加尔各答，孟买，新德里</option>
                                  <option value="Asia/Katmandu">(UTC+05:45)加德满都</option>
                                  <option value="Asia/Novosibirsk">(UTC+06:00)新西伯利亚(RTZ 5)</option>
                                  <option value="Asia/Dhaka">(UTC+06:00)达卡</option>
                                  <option value="Asia/Almaty">(UTC+06:00)阿斯塔纳</option>
                                  <option value="Asia/Rangoon">(UTC+06:30)仰光</option>
                                  <option value="Asia/Krasnoyarsk">(UTC+07:00)克拉斯诺亚尔斯克(RTZ 6)</option>
                                  <option value="Asia/Bangkok">(UTC+07:00)曼谷，河内，雅加达</option>
                                  <option value="Asia/Ulaanbaatar">(UTC+08:00)乌兰巴托</option>
                                  <option value="Asia/Irkutsk">(UTC+08:00)伊尔库茨克(RTZ 7)</option>
                                  <option value="Asia/Shanghai">(UTC+08:00)北京，重庆，香港特别行政区，乌鲁木齐</option>
                                  <option value="Asia/Taipei">(UTC+08:00)台北</option>
                                  <option value="Asia/Singapore">(UTC+08:00)吉隆坡，新加坡</option>
                                  <option value="Australia/Perth">(UTC+08:00)珀斯</option>
                                  <option value="Asia/Tokyo">(UTC+09:00)大阪，札幌，东京</option>
                                  <option value="Asia/Yakutsk">(UTC+09:00)雅库茨克(RTZ 8)</option>
                                  <option value="Asia/Seoul">(UTC+09:00)首尔</option>
                                  <option value="Australia/Darwin">(UTC+09:30)达尔文</option>
                                  <option value="Australia/Adelaide">(UTC+09:30)阿德莱德</option>
                                  <option value="Pacific/Port_Moresby">(UTC+10:00)关岛，莫尔兹比港</option>
                                  <option value="Australia/Sydney">(UTC+10:00)堪培拉，墨尔本，悉尼</option>
                                  <option value="Australia/Brisbane">(UTC+10:00)布里斯班</option>
                                  <option value="Asia/Vladivostok">(UTC+10:00)符拉迪沃斯托克，马加丹(RTZ 9)</option>
                                  <option value="Australia/Hobart">(UTC+10:00)霍巴特</option>
                                  <option value="Asia/Magadan">(UTC+10:00)马加丹</option>
                                  <option value="Asia/Srednekolymsk">(UTC+11:00)乔库尔达赫(RTZ 10)</option>
                                  <option value="Pacific/Guadalcanal">(UTC+11:00)所罗门群岛，新喀里多尼亚</option>
                                  <option value="Etc/GMT-12">(UTC+12:00)协调世界时+12</option>
                                  <option value="Pacific/Auckland">(UTC+12:00)奥克兰，惠灵顿</option>
                                  <option value="Pacific/Fiji">(UTC+12:00)斐济</option>
                                  <option value="Asia/Kamchatka">(UTC+12:00)阿纳德尔，彼得罗巴甫洛夫斯克-堪察加(RTZ 11)</option>
                                  <option value="Pacific/Tongatapu">(UTC+13:00)努库阿洛法</option>
                                  <option value="Pacific/Apia">(UTC+13:00)萨摩亚群岛</option>
                                  <option value="Pacific/Kiritimati">(UTC+14:00)圣诞岛</option>
                                  <option value="Atlantic/Azores">(UTC-01:00)亚速尔群岛</option>
                                  <option value="Atlantic/Cape_Verde">(UTC-01:00)佛得角群岛</option>
                                  <option value="Etc/GMT+2">(UTC-02:00)协调世界时-02</option>
                                  <option value="America/Cayenne">(UTC-03:00)卡宴，福塔雷萨</option>
                                  <option value="America/Sao_Paulo">(UTC-03:00)巴西利亚</option>
                                  <option value="America/Buenos_Aires">(UTC-03:00)布宜诺斯艾利斯</option>
                                  <option value="America/Godthab">(UTC-03:00)格陵兰</option>
                                  <option value="America/Bahia">(UTC-03:00)萨尔瓦多</option>
                                  <option value="America/Montevideo">(UTC-03:00)蒙得维的亚</option>
                                  <option value="America/St_Johns">(UTC-03:30)纽芬兰</option>
                                  <option value="America/La_Paz">(UTC-04:00)乔治敦，拉巴斯，马瑙斯，圣胡安</option>
                                  <option value="America/Asuncion">(UTC-04:00)亚松森</option>
                                  <option value="America/Halifax">(UTC-04:00)大西洋时间(加拿大)</option>
                                  <option value="America/Cuiaba">(UTC-04:00)库亚巴</option>
                                  <option value="America/Caracas">(UTC-04:30)加拉加斯</option>
                                  <option value="America/New_York">(UTC-05:00)东部时间(美国和加拿大)</option>
                                  <option value="America/Indianapolis">(UTC-05:00)印地安那州(东部)</option>
                                  <option value="America/Bogota">(UTC-05:00)波哥大，利马，基多，里奥布朗库</option>
                                  <option value="America/Guatemala">(UTC-06:00)中美洲</option>
                                  <option value="America/Chicago">(UTC-06:00)中部时间(美国和加拿大)</option>
                                  <option value="America/Mexico_City">(UTC-06:00)瓜达拉哈拉，墨西哥城，蒙特雷</option>
                                  <option value="America/Regina">(UTC-06:00)萨斯喀彻温</option>
                                  <option value="America/Phoenix">(UTC-07:00)亚利桑那</option>
                                  <option value="America/Chihuahua">(UTC-07:00)奇瓦瓦，拉巴斯，马萨特兰</option>
                                  <option value="America/Denver">(UTC-07:00)山地时间(美国和加拿大)</option>
                                  <option value="America/Santa_Isabel">(UTC-08:00)下加利福尼亚州</option>
                                  <option value="America/Los_Angeles">(UTC-08:00)太平洋时间(美国和加拿大)</option>
                                  <option value="America/Anchorage">(UTC-09:00)阿拉斯加</option>
                                  <option value="Pacific/Honolulu">(UTC-10:00)夏威夷</option>
                                  <option value="Etc/GMT+11">(UTC-11:00)协调世界时-11</option>
                                  <option value="Etc/GMT+12">(UTC-12:00)国际日期变更线西</option>
                            </select>
				</div>
			</div>
			
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">服务器时间</label>
				<div class="layui-input-block">
					<input type="text" id="serverdate" value="<%=time%>"
						class="layui-input" disabled="disabled">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn"  lay-filter="formDemo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>

		</form>
	</div>
</div>

<script src="jsp/lib/layui/layui.js"></script>
<script type="text/javascript">
layui.use('form');
</script>