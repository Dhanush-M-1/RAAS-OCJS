n, k = list(map(int, input().split()))
a = []
b = []
ab = []
for _ in range(0, n):
    t, x, y = list(map(int, input().split()))
    if (x == 1 and y == 1):
        ab.append(t)
    elif (x == 1):
        a.append(t)
    elif (y == 1):
        b.append(t)

    # print(a, b, ab)
ab.sort(reverse=True)
b.sort(reverse=True)
a.sort(reverse=True)
ca = 0
cb = 0
t = 0
c = 0
u = 0
while (len(a) != 0 and len(b) != 0):
    if (len(ab) > 0 and ab[-1] <= a[-1] + b[-1]):
        t += ab.pop()
        c += 1
    else:

        t = t + a.pop() + b.pop()
        c += 1
    if (c == k):
        u = 1
        break
if (u == 1):
    print(t)
elif (c + len(ab) < k):
    print(-1)
else:
    t += sum(ab[-(k - c):])
    print(t)
