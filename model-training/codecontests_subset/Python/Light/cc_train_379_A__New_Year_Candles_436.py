a, b = [int(i) for i in input().split()]

ans = 0
c = 0
while a > 0:
    ans += a
    a, c = (a + c) // b, (a + c) % b
print(ans)