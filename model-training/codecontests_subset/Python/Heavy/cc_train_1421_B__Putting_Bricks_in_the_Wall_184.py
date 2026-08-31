import sys
for i in range(int(sys.stdin.readline())):
    a = []
    for z in range(int(sys.stdin.readline())):
        a.append(str(sys.stdin.readline().strip()))
    g1 = a[1][0]
    g2 = a[0][1]
    c1 = a[len(a)-2][len(a)-1]
    c2 = a[len(a)-1][len(a)-2]
    stat = False
    stat2 = False
    gstat = None
    cstat = None
    if g1 == g2:
        stat = True
        gstat = g1
    if c1 == c2:
        stat2 = True
        cstat = c1
    if gstat != None and cstat != None:
        if gstat == cstat:
            print(2)
            print(1,2)
            print(2,1)
        else:
            print(0)
    elif gstat == None and cstat != None:
        if g1 == cstat:
            print(1)
            print(2,1)
        else:
            print(1)
            print(1,2)
    elif cstat == None and gstat != None:
        if c1 == gstat:
            print(1)
            print(len(a)-1,len(a))
        else:
            print(1)
            print(len(a),len(a)-1)
    else:
        if g1 == c1:
            print(2)
            print(1,2)
            print(len(a)-1,len(a))
        else:
            print(2)
            print(1,2)
            print(len(a),len(a)-1)
        
            
        
