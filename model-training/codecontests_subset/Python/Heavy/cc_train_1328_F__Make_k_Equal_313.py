def mp():
    return map(int, input().split())

def f(a, b):
    res = 0
    while b > a:
        b //= 2
        res += 1
    if b != a:
        res = -1
    return res

n, k = mp()
a = sorted(list(mp()))
b = set()
for i in a:
    x = i
    while x > 0:
        b.add(x)
        x //= 2
b.add(0)

tot = 10 ** 20
for x in b:
    ans = cnt = 0
    for i in range(n):
        if a[i] == x:
            cnt += 1
        elif a[i] > x:
            res = f(x, a[i])
            if res != -1:
                ans += res
                cnt += 1
        if cnt >= k:
            break
    if cnt >= k and ans < 10 ** 20:
        tot = min(tot, ans)
        #print(x, ans)

print(tot)