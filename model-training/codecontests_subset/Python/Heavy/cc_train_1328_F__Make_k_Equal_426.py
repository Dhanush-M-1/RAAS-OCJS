n, m = map(int, input().split())
data = list(map(int, input().split()))
data.sort()
last = -120
CONST = 2 * 10 ** 5 + 1
ans = 10 ** 15
for i in range(CONST):
    c, kol = 0, 0
    if data[-1] < i:
        break
    for j in data:
        if kol == m:
            ans = min(ans, c)
            break
        if j > i:
            k = 0
            t = j
            while t > i:
                t //= 2
                k += 1
            if t == i:
                c += k
                kol += 1
        elif j == i:
            kol += 1
    if kol == m:
        ans = min(ans, c)
print(ans)