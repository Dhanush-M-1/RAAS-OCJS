from collections import Counter
for _ in range(int(input())):
    leng = int(input())
    c = [int(x) for x in input().split()]
    d = Counter(c)
    z = sorted(d.items(),reverse=True)
    if(len(z)<3):
        print("0 0 0")
        continue
    g = 0
    cG = z[0][1]
    s = 1
    cS = z[1][1]
    b = 2
    cB = z[2][1]
    totDif = len(z)
    imp = False
    while(cG >= cS):
        s+=1
        if(b+1>=totDif):
            imp = True
            break
        b+=1
        cS += z[s][1]
        cB -= z[s][1]
        cB += z[b][1]
    if(imp == True):
        print("0 0 0")
        continue
    while(cG >= cB):
        if(b+1>=totDif):
            imp = True
            break
        b+=1
        cB+=z[b][1]
    if(imp == True):
        print("0 0 0")
        continue
    if(cG+cS+cB>int(leng/2)):
        print("0 0 0")
        continue
    act = cG+cS+cB
    varr = int(leng/2)
    while(True):
        if(b+1>=totDif):
            break
        b+=1
        if(act+z[b][1]<=varr):
            cB += z[b][1]
            act+=z[b][1]
        else:
            break
        
    print(str(cG) + " " + str(cS) + " " + str(cB))
    continue