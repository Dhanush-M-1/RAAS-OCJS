n = int(input())
a = sorted(list(map(int,input().split())))
b = sorted(list(map(int,input().split())))
c = sorted(list(map(int,input().split())))
c1 = 0;c2 = 0
b.append(-1)
c.append(-1)
c.append(-1)
for i in range(n) :
    if(a[i]!=b[i] and c1==0) :
        print(a[i])
        c1 += 1
for i in range(n) :
    if(b[i]!=c[i] and c2==0) :
        print(b[i])
        c2 += 1