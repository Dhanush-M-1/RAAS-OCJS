n = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
c = list(map(int,input().split()))
a = sorted(a)
b = sorted(b)
c = sorted(c)
for i in range(len(b)):
    if a[i]!=b[i]:
        print(a[i])
        break
else:
        print(a[n-1])
for i in range(len(c)):
    if b[i]!=c[i]:
        print(b[i])
        break
else:
        print(b[n-2])