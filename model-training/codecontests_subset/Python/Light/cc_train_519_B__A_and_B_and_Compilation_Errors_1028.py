n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
a.sort()
b.sort()
c.sort()
f1=0
for i in range(len(b)):
    if a[i]==b[i]:
        continue
    else:
        f1=1
        print(a[i])
        break
if f1==0:
    print(a[-1])
f2=0
for i in range(len(c)):
    if b[i]==c[i]:
        continue
    else:
        f2=1
        print(b[i])
        break
if f2==0:
    print(b[-1])        