n = int(input())
a = list(map(int,input().split(" ")))
b = list(map(int,input().split(" ")))
c = list(map(int,input().split(" ")))

a.sort()
b.sort()
c.sort()

f = False

for i in range(0,n-1):
    if b[i] != a[i]:
        print(a[i])
        f = True
        break

if not f :
    print(a[n-1])

f = False

for i in range(0,n-2):
    if b[i] != c[i]:
        print(b[i])
        f = True
        break
if not f :
    print(b[n-2])
