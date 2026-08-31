n=int(input())
a=list(map(int,input().split()))
a.sort()
b=list(map(int,input().split()))
b.sort()
c=list(map(int,input().split()))
c.sort()
for i in range(n-1):
    if a[i]!=b[i]:
        print(a[i])
        break
    elif i==n-2:
        print(a[n-1])
for j in range(n-2):
    if b[j]!=c[j]:
        print(b[j])
        break
    elif j==n-3:
        print(b[n-2])