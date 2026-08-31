n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
a.sort()
b.sort()
c.sort()
for i in range(len(b)):
    if b[i]!=a[i]:
        print(a[i])
        break
    elif i==(len(b)-1):
        print(max(a))
for i in range(len(c)):
    if c[i]!=b[i]:
        print(b[i])
        break
    elif i==(len(c)-1):
        print(max(b))