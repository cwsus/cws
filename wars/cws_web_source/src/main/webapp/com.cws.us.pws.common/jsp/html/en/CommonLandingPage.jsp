<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${fn:replace(req.requestURL, fn:substring(req.requestURI, 1, fn:length(req.requestURI)), 'html')}" />

<c:import url="${baseURL}/cws/main-bulletin.htm" />

<div class="middle-column-box-full-standard">
    <div class="middle-column-title-standard">CaspersBox Web Services</div>
            
    CaspersBox Web Services is a full service software development and implementation
    provider. We can develop your web presence and provide you with the tools to maintain
    that presence - allowing you to worry about more important things, like your Company.
    With 8 years experience designing, developing, and implementing software services, you
    can rest assured that we will be here for you from beginning to end.
</div>

<div class="middle-column-box-left-standard">
    <div class="middle-column-title-standard">Content Management Issues?</div>

    Infinix is the premier content management system for all size websites. Whether your
    site has 5 pages, or 500, Infinix can manage them with ease from anywhere in your
    organization. <a href="Pages/Products.aspx?ProdID=IMS" title="Infinix">Read More...</a>
</div>

<div class="middle-column-box-right-standard">
    <div class="middle-column-title-standard">Invoicing for Professionals</div>

    Worried about your invoicing platform? Give Angel a try. Angel seamlessly integrates with
    your eCommerce website, your billing databases, your Customer Information systems, and
    much more. <a href="Pages/Products.aspx?ProdID=AIS" title="Angel">Read More...</a>
</div>
