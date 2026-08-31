input()
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
a.sort()
b.sort()
c.sort()
for i in range(len(b)):
    if a[i]!=b[i]:
        print(a[i])
        break
else:
    print(a[-1])
for i in range(len(c)):
    if b[i]!=c[i]:
        print(b[i])
        break
else:
    print(b[-1])
