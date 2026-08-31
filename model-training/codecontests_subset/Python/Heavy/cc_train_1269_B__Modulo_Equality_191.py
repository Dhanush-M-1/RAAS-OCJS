from collections import deque
n, m = map(int, input().split())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]
a.sort()
b.sort()
if (a == b):
    print(0)
    exit(0)
q1 = deque()
q2 = deque()
for i in range(n):
    q1.append(a[i])
    q2.append(b[i])

ans = m+10
for i in range(n):
    t = q1.popleft()
    q1.append(t)
    tmp = (q2[0] - q1[0]) % m
    fin = True
    for j in range(n):
        if ((q1[j] + tmp) % m != q2[j]):
            fin = False
            break
    if (fin == True):
        ans = min(ans, tmp)
print(ans)
