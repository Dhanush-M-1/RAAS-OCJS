var q = readline()
for(var i=0; i<q; i++) {
    line = readline().split(" ").map(Number)
    l = line[0]
    r = line[1]
    d = line[2]
    
    if(d < l || d > r) {
        print(d)
    } else {
        print((Math.floor(r/d) + 1) * d)
    }
}