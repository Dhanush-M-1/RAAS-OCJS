n = int(input())

a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]
c = [int(x) for x in input().split()]

a.sort()
b.sort()
c.sort()

acount = 0

for i in range(n-1):
    if a[i] != b[i]:
        err1 = a[i]
        break
    else:
        acount += 1
if acount == n - 1:
    err1 = a[n-1]

acount = 0

for i in range(n-2):
    if b[i] != c[i]:
        err2 = b[i]
        break
    else:
        acount += 1
if acount == n - 2:
    err2 = b[n-2]

print(err1)
print(err2)





