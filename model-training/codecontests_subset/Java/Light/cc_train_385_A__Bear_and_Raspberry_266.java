(function() {
    var nc = readline().split(' ');
    var mx = 0, pr;
    
    readline().split(' ').forEach(function (x){
        if ( pr !== undefined ) {
            mx = Math.max(mx,pr-x-nc[1]);
        }
        pr = x;
    });
    
    print(mx);
})();