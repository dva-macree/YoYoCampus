function BackTop() {
    this.init();
}
BackTop.prototype = {
    constructor: BackTop,
    init: function() {
        this._initBackTop();
    },
    _initBackTop: function() {
        var $backTop = this.$backTop = $('<div href="javascript:;" class="backToTop" title="返回顶部"></div>');
        $('body').append($backTop);
        $backTop.click(function() {
            $("html, body").animate({
                scrollTop: 0
            },
            500);
        });
        var timmer = null;
        $(window).bind("scroll",
        function() {
            var d = $(document).scrollTop(),
            e = $(window).height();
            0 < d ? $backTop.css("bottom", "60px") : $backTop.css("bottom", "-130px");
            clearTimeout(timmer);
            timmer = setTimeout(function() {
                clearTimeout(timmer)
            },
            100);
        });
    }
}