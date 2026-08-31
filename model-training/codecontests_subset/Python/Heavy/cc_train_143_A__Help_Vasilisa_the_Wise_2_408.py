
s = input().split()
r1 = int(s[0])
r2 = int(s[1])
s = input().split()
c1 = int(s[0])
c2 = int(s[1])
s = input().split()
d1 = int(s[0])
d2 = int(s[1])

b = (r1+d2-c1)
a = r1+d1-c2
d = r2+d1-c1
c = r2+d2-c2

if a%2!=0 or a<0 or a//2>9 or b%2!=0 or b<0 or b//2>9 or c%2!=0 or c<0 or c//2>9 or d%2!=0 or d<0 or d//2>9:
    print(-1)
else:
    has = [0 for i in range(10)]
    has[a//2]+=1
    has[b//2]+=1
    has[c//2]+=1
    has[d//2]+=1
    res = True
    for j in range(1,10):
        if has[j]>1:
            res = False

    if not res or has[0]!=0:
        print(-1)
    else:
        print(str(a//2)+" "+str(b//2))
        print(str(c//2)+" "+str(d//2))



