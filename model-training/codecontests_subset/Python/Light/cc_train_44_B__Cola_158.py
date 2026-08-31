n, c, b, a = map(int, input().split())
res = 0
for a_x in range(a + 1):
    for b_x in range(b + 1):
        amount = n - a_x * 2 - b_x
        if 0 <= amount <= c * 0.5:
            res += 1
print(res)
