n, k = map(int,input().split())
a = b = c = 0
m = []
m1 = []
m2 = []
for i in range(n):
    a, b, c = map(int,input().split())
    if b == c == 1:
        m.append(a)
    elif b > c:
        m1.append(a)
    elif b < c:
        m2.append(a)

m.sort()
m1.sort()
m2.sort()

for i in range(min(len(m1), len(m2))):
    m.append(m1[i]+m2[i])

m.sort()

if len(m) < k:
    print(-1)
else:
    print(sum(m[:k]))
            