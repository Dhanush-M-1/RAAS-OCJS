n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
a=sorted(a)
b=sorted(b)
c=sorted(c)
status=False
for i in range(len(b)):
    if a[i]!=b[i]:
        print(a[i])
        status=True
        break
if status==False:
    print(a[-1])

status=False
for i in range(len(c)):
    if b[i]!=c[i]:
        print(b[i])
        status=True
        break
if status==False:
    print(b[-1])
