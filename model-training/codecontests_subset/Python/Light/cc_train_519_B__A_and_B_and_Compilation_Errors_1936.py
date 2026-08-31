n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
b.append(2147483647)
c.append(2147483647)
c.append(2147483647)
a=sorted(a)
b=sorted(b)
c=sorted(c)
for i in range(n):
    if(a[i]!=b[i]):
        print(a[i])
        break
for i in range(n):
    if(b[i]!=c[i]):
        print(b[i])
        break