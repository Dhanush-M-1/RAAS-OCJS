n = int(input())
a = list(map(int, input().split()))

need = {i: False for i in range(1, 10 ** 6 + 1)}
for i in a:
    need[i] = True

l, r = 1, 10 ** 6
c = 0
ans = 0

while True:
    ans += 1
    l += 1
    r -= 1

    c += need[l]
    c += need[r]

    if c == n:
        print(ans)
        break
