var s = readline().split( ' ' ),
    size = s[1] - '';

var mem = [];

for (; s = readline(); ) {
    switch (s.charAt( 0 )) {
        case 'a': alloc( s.replace( 'alloc ', '' ) - '' ); break;
        case 'e': erase( s.replace( 'erase ', '' ) - '' ); break;
        default: defragment();
    }
}

function alloc(x) {
    var next = alloc._ = alloc._ || 1;
    for (var i=1, j=0; i<size+1 && j<x; i++) {
        j = !!mem[i] ? 0 : j+1;
    }

    if (x === j) {
        alloc._++;
        print( next );
        for (j=i, i=i-x; i<j; i++) {
            mem[i] = next;
        }
    } else {
        print( 'NULL' );
    }
}

function erase(x) {
    for (var i=1, j=0; i<size+1; i++) {
        if (mem[i] === x) {
            mem[i] = 0; j = i;
        }
    }

    !j && print( 'ILLEGAL_ERASE_ARGUMENT' );
}

function defragment() {
    for (var j=1, i=1; i<size+1; i++) {
        if (!!mem[i]) {
            mem[j++] = mem[i]; j !== i+1 && (mem[i] = 0);
        }
    }
}