a = int(input())
b = sorted(list(map(int,input().split())))
c = sorted(list(map(int,input().split())))
d = sorted(list(map(int,input().split())))
e = 0
f = 0
for n in range(a-1):
    if c[n]-b[n]>0:
        print(b[n])
        break
    else:
        e += 1
if e == a-1:
    print(b[a-1])

for n in range(a-2):
    if d[n]-c[n]>0:
        print(c[n])
        break
    else:
        f += 1
if f == a-2:
    print(c[a-2])
