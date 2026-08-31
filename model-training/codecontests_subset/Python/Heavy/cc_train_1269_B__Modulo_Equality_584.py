A,m = map(int,input().split(" "))
c = list(map(int,input().split(" ")))
d = list(map(int,input().split(" ")))
C = sorted(c);D = sorted(d)
if C == D:
    print(0)
else:
    li =[];l=[]
    x = min(D)
    E = list(set(C))
    #print(E)
    for i in E:
        F = C.copy()
        if i < m:
            if x<i:
                z = m-i+x
            else:
                z = x - i
        elif i>m:
            for j in range(m,1000000001,m):
                if j >i:
                    z = j - i + x
                    break
        if z not in li:            
            final = list(map(lambda x: (x+z)%m,F))
            #print(z,final)
            li.append(z)
            if sorted(final) == D:
                l.append(z)
    print(min(l))
        
            