# employee-demo-project

curl --header "content-type: text/xml" -d @employeeReq.xml http://localhost:8080/ws | xmllint --format -

http://localhost:8080/ws/employees.wsdl




			<plugin>
				<groupId>org.jvnet.jaxb2.maven2</groupId>
				<artifactId>maven-jaxb2-plugin</artifactId>
				<version>0.15.3</version>
				<executions>
					<execution>
						<goals>
							<goal>generate</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<generateDirectory>${project.basedir}/src/main/java</generateDirectory>
					<generatePackage>com.example.verification.Employee</generatePackage>
					<schemaDirectory>${project.basedir}/src/main/resources/wsdl</schemaDirectory>
					<schemaIncludes>
						<include>*.wsdl</include>
					</schemaIncludes>
				</configuration>
			</plugin>
