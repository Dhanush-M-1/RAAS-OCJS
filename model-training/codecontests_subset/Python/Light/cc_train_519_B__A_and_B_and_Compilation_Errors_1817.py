n=int(input())
a=sorted(list(map(int,input().strip().split())))
b=sorted(list(map(int,input().strip().split())))
c=sorted(list(map(int,input().strip().split())))
q=a[-1]
for i in range(len(b)):
    if a[i]!=b[i]:
        q=a[i]
        break
print(q)
q=b[-1]
for i in range(len(c)):
    if b[i]!=c[i]:
        q=b[i]
        break
print(q)
