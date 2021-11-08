<p>deploy services in Docker</p>
</br>


`mvn clean package`
</br>
`docker-compose up`

services
<table>
<tr>
<td>service</td>
<td>host</td>
<td>credentials</td>
</tr>
<tr>
<td>eureka-server</td>
<td>http://localhost:8761</td>
<td></td>
</tr>
<tr>
<td>rabbitmq</td>
<td>http://localhost:5672</td>
<td>user / pass</td>
</tr>
<tr>
<td>prometheus</td>
<td>http://localhost:9090</td>
<td></td>
</tr>
<tr>
<td>grafana</td>
<td>http://localhost:3000</td>
<td>user / pass</td>
</tr>
<tr>
<td>micro-sender</td>
<td>http://localhost:8081</td>
<td></td>
</tr>
<tr>
<td>micro-recipient</td>
<td>http://localhost:8082</td>
<td></td>
</tr>
<tr>
<td>micro-collector</td>
<td>http://localhost:8083</td>
<td></td>
</tr>
</table>