n = int(input())
a = sorted(list(map(int,input().split())))
b = sorted(list(map(int,input().split())))
c = sorted(list(map(int,input().split())))
l=0
for i in range(n-1):
    if a[i]!=b[i]:
        print(a[i])
        l+=1
        break
if l==0:
    print(a[n-1])
l=0
for i in range(n-2):
    if b[i]!=c[i]:
        print(b[i])
        l+=1
        break
if l==0:
    print(b[n-2])