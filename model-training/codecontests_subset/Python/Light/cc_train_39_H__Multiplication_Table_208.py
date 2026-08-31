def turn(i, j, k):
    p = i * j
    ans = ""
    while p > 0:
        t = p % k
        ans += str(t)
        p //= k
    return ans[::-1]


k = int(input())
for i in range(1, k):
    t = []
    for j in range(1, k):
        t.append(turn(i, j, k))
    print(*t, sep=" ")