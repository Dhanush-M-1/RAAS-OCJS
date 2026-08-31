a, b = map(int, input().split())
ans = 0
dead_ones = 0
# a = alive_ones
while a > 0:
    ans += a
    dead_ones += a
    a = dead_ones // b
    dead_ones %= b
print(ans)