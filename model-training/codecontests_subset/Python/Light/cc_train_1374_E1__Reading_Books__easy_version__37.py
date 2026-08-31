n,k=map(int,input().split())
a =[]
b =[]
c = []
for i in range(n):
        m = [*map(int,input().split())]
        if(m[1]==1 and m[2]==1):
            c.append(m[0])
        elif(m[1]==1):
            a.append(m)
        elif(m[2]==1):
            b.append(m)
a.sort(key=lambda x:(x[0]))
b.sort(key=lambda x:(x[0]))
for i in range(min(len(a),len(b))):
    c.append(a[i][0]+b[i][0])
c.sort()
if(len(c)<k):
    print(-1)
else:
    print(sum(c[i] for i in range(k)))
