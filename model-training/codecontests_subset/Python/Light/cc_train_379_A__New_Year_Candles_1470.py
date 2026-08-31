a, b = map(int, input().split())

ans = 0
used = 0
while a!= 0:
    ans += 1
    a -= 1
    used += 1
    if used == b:
        used = 0
        a += 1
print(ans)