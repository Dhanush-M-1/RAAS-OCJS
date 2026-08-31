n =int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c=list(map(int, input().split()))
a.sort()
b.sort()
c.sort()
d = []
res = 0
count = 0
z = 0
x =0
for i in range(len(b)):
    if a[i]!= b[i]:
        d.append(a[i])
        res+=1
        z+=1
        if z>0:
            break

if res==0:
        d.append(a[-1])

for i in range(len(c)):
    if b[i] != c[i]:
        d.append(b[i])
        count +=1
        x+=1
        if x>0:
            break
if count == 0:
    d.append(b[-1])


print(*d)