n, m = map(int, input().split())
a = []
e = 0

for i in range(n):
    l = list(map(int, input().split()))
    a += l[1:]
    b = list(set(a))

for j in range(1, m+1):
    if j in b:
        e += 1

if e == m:
    print("YES")
else:
    print("NO")            