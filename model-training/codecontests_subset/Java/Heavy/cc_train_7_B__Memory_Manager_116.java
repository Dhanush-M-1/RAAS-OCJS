var a = readline().split(' ').map(function (e){
	return parseInt(e);
});
var n = a[0], m = a[1];
var mem = [{
	'id': NaN,
	'begin': 0,
	'end': 0
}], cnt = 0;
function alloc(i, len) {
	mem.splice(i, 0, {
		'id': ++cnt,
    	'begin': mem[i - 1].end + 1,
    	'end': mem[i - 1].end + len,
    });
    print(cnt);
}
for (var i = 0; i < n; ++i) {
	a = readline().split(' ');
	switch (a[0]) {
    	case 'alloc': {
    		var find = false;
        	var len = parseInt(a[1]);
        	for (var j = 0; j < mem.length - 1; ++j) {
       	        if (mem[j + 1].begin - 1 - mem[j].end >= len) {
                	alloc(j + 1, len);
                	find = true; break;
                }
            } 
            if (!find) {
            	if (m - mem[mem.length - 1].end >= len) {
	            	alloc(mem.length, len);
	            } else {
                    print('NULL');
                }
            }
        } break;
        case 'erase': {
        	var id = parseInt(a[1]);
        	var find = false;
        	for (var j = 0; j < mem.length; ++j) {
            	if (mem[j]['id'] === id) {
                	mem.splice(j, 1);
                	find = true; break;
                }
            }
            if (!find) {
            	print('ILLEGAL_ERASE_ARGUMENT');
            }
        } break;
        case 'defragment': {
        	for (var j = 1; j < mem.length; ++j) {
        		var len = mem[j].end - mem[j].begin;
            	mem[j].begin = mem[j - 1].end + 1 || 1;
            	mem[j].end = mem[j].begin + len;
            }
        } break;
    }
}
