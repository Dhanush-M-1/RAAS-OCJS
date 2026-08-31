def divisor(i):
    s = []
    for j in range(1, int(i ** (1 / 2)) + 1):
        if i % j == 0:
            s.append(i // j)
            s.append(j)
    return sorted(set(s))

n, p = map(int, input().split())
s = divisor(p)
s.reverse()
ans = 1
for i in s:
    c = i
    m = 0
    if not i * n > p and not i == 1:
        if i % p == 0:
            m = 1
        for _ in range(n - 1):
            if c > p:
                m = 0
                break
            else:
                m = 1
            c = c * i
    if p % c == 0 and m == 1:
        ans = i
        break
print(ans)