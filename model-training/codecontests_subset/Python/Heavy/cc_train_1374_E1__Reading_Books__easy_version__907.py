from sys import stdin
n,k = map(int,stdin.readline().split())
a = []
b = []
both = []
for _ in range(n):
    t,x,y = map(int,stdin.readline().split())
    if x==1 and y==1:
        both.append(t)
    elif x==1:
        a.append(t)
    elif y==1:
        b.append(t)
a.sort()
b.sort()
both.sort()
if len(both)+len(a)<k or len(both)+len(b)<k:
    print(-1)
else:
    li=i=j=ti=0
    while li != k:
        if i==min(len(a),len(b)):
            ti += both[j]
            j += 1
        elif j==len(both):
            ti += a[i]+b[i]
            i += 1
        elif a[i]+b[i]<both[j]:
            ti += a[i]+b[i]
            i += 1
        elif a[i]+b[i]>=both[j]:
            ti+=both[j]
            j += 1
        li += 1
    print(ti)