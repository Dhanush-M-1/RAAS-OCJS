n = int(input())
for i in range (n):
    k = int(input())
    g = 0
    s = 0
    b = 0
    gcount = 0
    scount = 0
    bcount = 0
    bb = 0
    m=list(map(int,input().split()))
    for j in range(k):
        if g == 0:
            g += 1
            gcount = m[j]
        elif gcount == m[j]:
            g += 1
        elif s<=g:
            scount = m[j]
            s += 1
        elif scount == m[j]:
            s += 1
        elif b<=g:
            bcount = m[j]
            b += 1
        elif bcount == m[j]:
            b += 1
        else:
            if bcount != m[j]:
                bb = b
                bcount = m[j]
            b+=1
        if (g+s+b)*2>k: 
            break
    if bb == 0:
        print(0,0,0)
    else:
        print(g,s,bb)
        
