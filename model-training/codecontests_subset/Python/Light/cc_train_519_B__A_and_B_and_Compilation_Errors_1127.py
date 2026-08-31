n=int(input())
a=sorted(list(map(int,input().split())))
b=sorted(list(map(int,input().split())))
c=sorted(list(map(int,input().split())))
for i in range(n-1):
    if a[i]!=b[i]:
        print(a[i])
        break
else:
    print(a[n-1])
for i in range(n-2):
    if b[i]!=c[i]:
        print(b[i])
        break
else:
    print(b[n-2])
