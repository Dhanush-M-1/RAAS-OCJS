a, b = map(int, input().split())

ans = 0
while a > 0:
    ans += 1
    if ans % b:
        a -= 1

print(ans)
