a, b = map(int, input().split())
x = cnt = 0
while a > 0:
    a -= 1
    cnt += 1
    x += 1
    if x % b == 0:
        a += 1
print(cnt)