a, b = map(int, input().split())
used = 0
while a > 0:
    used += 1
    if used % b == 0:
        a += 1
    a -= 1
print(used)
