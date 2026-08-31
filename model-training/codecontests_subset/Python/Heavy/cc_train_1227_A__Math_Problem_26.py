n = int(input())

for i in range(n):
    m = int(input())
    r = 999999999999999999
    l = 0
    typ = 0
    
    
    
    for i in range(m):    
        a, b = map(int, input().split())
            
        if typ == 0:     
            if a < l and b < l:
                r = l
                l = b
                typ = 1
            elif b > r and a > r:
                l = r
                r = a
                typ = 1
            else:
                minr = min([r, b])
                maxl = max([l, a])
                l = maxl
                r = minr
                typ = 0
        
        else:
            if a < l and b < l:
                l = b
            elif b > r and a > r:
                r = a
        
    if typ == 0:
        print(0)
    else:
        print(r - l)
    