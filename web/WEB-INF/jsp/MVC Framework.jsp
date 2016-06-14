<main>
    <div class="container">
        <div class="row">
            <div class="col m12">
                <div id="header">
                    Distributed Applications<br>
                    KU Leuven - Campus Groep T<br>
                    2015-2016<br>
                </div>
                <div id="groupmembers">
                    <ul>
                        <li>Karsten Gielis</li>
                        <li>Wouter Meuwis</li>
                        <li>Evert Borghgraef</li>
                    </ul>
                </div>
                <h1>Spring MVC;</h1>
                <h2>Short description</h2>
                <p>The Spring Framework provides a comprehensive programming and configuration model for modern Java-based enterprise applications - 
                    on any kind of deployment platform. A key element of Spring is infrastructural support at the application level: Spring focuses 
                    on the "plumbing" of enterprise applications so that teams can focus on application-level business logic, without unnecessary ties to specific deployment environments.</p>
                <h2>Technical features</h2>
                <h3>MVC solution</h3>
                <p>
                    Requests are mapped in the web.xml to the front controller, the appplication servlet. 
                    This front controller scans the available packages for controllers, annotated with @Controller, and maps which controller should be used for every URI, annotated by @RequestMapping.
                    When the request is mapped to the right controller, the controller creates the model, fetching and manipulating all necessary data.
                    The controller requests a viewTemplate in a new ModelAndView, and adds the model to it. This ModelAndView is passed to the FrontController.
                    He fetches the correct viewTemplate, which is resolved through the viewResolver, and populates with the data from the model.
                    This populated template is returned to the client.    </p>
                <img src="<c:url value="${initParam.monkeyImagePath}spring_mvc.png" />" >
                <h3>Navigation</h3>
                <p>The FrontController scans all controllers. Controllers define the mapping of their functions through @RequestMapping.
                    In this requestMapping the wanted URI's are defined as a value. Methods as POST and GET can also be added.</p>
                <h3>Form handling</h3>
                <p>
                    Forms contain an ID, method, action and a modelAttribute. 
                    The ID is an attribute for easy identification of the form. 
                    The method defines the action type (POST, GET, ...). 
                    The action posts the URI on which the Controller will respond.
                    The modelAttribute defines a bean which corresponds with the values of the form. When the form is submitted this bean will be created and populated with this info.
                    The Controller which corresponds with the URI in the action can request the modelAttribute bean with @ModelAttribute. He can than manipulate the form data in any way he wants.
                </p>
                <h3>Validation</h3>
                <p>Classes can be made which implement Validator. These Validators can check the integrity of a class. 
                    For example: a Validator on a Person class can check that a Person's age can't go below zero. If the instance is incorrect, it can be rejected.
                </p>
                <h3>Type conversion</h3>
                <p>In the core package there is a convertor SPI which can converts for example Strings to Integers. 
                    These conversions can be conditional and automatically called.
                </p>
                <h3>Server-side handling of user interface events</h3>
                <p>
                    For one, the user input can be routed to the controller depending on the forwarded URI in the action attribute. The user input can be passed through forms or REST calls.
                </p>
                <h3>Rendering</h3>
                <p>
                    Spring uses the View Template pattern to render the Web Pages. In this pattern, the JSP view is loaded with the internal
                    placeholder variables. Once the page is loaded the variables are populated by the model data that was also passed by the Controller to the view
                    in the constructer ModelAndView. The mapping from Controller to the wanted view is done by the ViewResolver.
                </p>
                <h3>I18N and L10N</h3>
                <p>
                    Localization is the act of programming an application in a way so that it can be adapted to a different region/language without having to change the code. 
                    Localization is the effective implementation of the different language/region.<br>
                    An example that could be implemented would be multi-language support. This would mean that the views would no longer contain actual text. 
                    Instead, they would contain keywords. The resources would contain an extra file for each language. These files map each keyword to a certain piece of text. 
                    The language can then easily be changed by selecting another 'translation file'.
                </p>
                <h3>JavaScript integration</h3>
                <p>
                    This is the same as in a regular web project when in the view pages. On controller level however it is more difficult but it can be done by using
                    a PrintWriter (from HttpServletResponse) with contentType as text/html. 
                </p>
                <h3> ...</h3>
                
                
                <h2>Documentation</h2>
                <h3>Kind of documentation, quality, up to date</h3>
                <p>
                    <a href="https://spring.io/docs">https://spring.io/docs</a>
                    <a href="https://spring.io/guides">https://spring.io/guides</a>
                    Spring is currently the most popular framework for Java EE. The framework is up-to-date with a lot of tutorials and guides available on the Spring website itself.
                </p>
                <h3>Community activity</h3>
                <p>
                    The Spring website has it's own question section with StackOverflow integration. On this page all Spring related questions are shown. The Spring development team is actively 
                    helping answering these questions.
                </p>
                <h2>Future evolution</h2>
                <p>
                    Spring is still releasing updates with the last one being on 14th of June!
                    The development team has also set 2016 as the goal for Spring 5.0 release. This release will fully support the new Java 8 standards,
                    a new HTTP Client API and concurrency enhancement.
                </p>
                <h2>Your perception</h2>
                <p>
                    At first Spring came over as daunting because it required Java EE functionality to be implemented differently. They use a different design pattern as the Vanilla Java EE.
                    Once you get the hang of it though, a lot of the background configurations are handled automatically by the framework. For example: when you don't use Spring you should hardcode your URI mapping
                    in the Web-XML which gives you a great sense of control, but it requires a lot of micro-managing and code overhead. Spring automates this with Component Scanning. But for this to work a lot of configuration has to be done.
                    Once this is configured, this greatly speeds up development. This is one of many examples which were hard to implement but extremely useful when further in the project.
                </p>
                <h3>Ease of use</h3>
                <p>
                    Once set up, it is really easy to use. A lot of functionality is automatically done by the framework. For example: a REST template easily maps objects to XML/JSON and back without the need for a separate parser class trough ResponseEntities.
                    Spring provides a special implementation for these controllers with @RESTController which also implements @Controller and @ResponseBody.
                    <br>
                    When using NetBeans, a lot of Spring code and templates can be auto generated. Netbeans also supports auto completion for the Spring attributes.
                </p>
                <h3>Ease of installation</h3>
                <p>
                    NetBeans has the Spring MVC framework built in, so it can be picked when starting a new project in the IDE.
                </p>
                <h3>Learning curve</h3>
                <p>
                    This has be put in a certain context. Due to the 7 thesis weeks in the beginning of the semester we were forced to learn Java EE in a very short timespan. The initial learning curve was very steep, 
                    but short. It was hard to get into it, you couldn't build a single application without help. Any minor adjustment could fail the build.
                    <br>
                    Once over this initial learning curve, development was easier and adding functionality was done in rapid succession. The things we were cursing about in the beginning turned out to be extremely useful in the end.
                    While at first we couldn't imagine that projects were developed like this, in the end we wished we'd known this technology in the course of web 2.0.
                </p>
                <img src="<c:url value="${initParam.monkeyImagePath}spring.png" />" >
                <h2>Practical information</h2>
                <h3>Website</h3>
                <p><a href=https://spring.io/">https://spring.io/</a></p>
                <h3>Download</h3>
                <p>
                    <a href="https://projects.spring.io/spring-framework/">https://projects.spring.io/spring-framework/</a>
                </p>
            </div>
        </div>
    </div>
</main>