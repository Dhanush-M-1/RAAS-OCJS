a, b = map(int, input().split())
ans = a
tmp = 0
while a:
    tmp = 0
    if a > b:
        tmp += a % b
    a = a // b + tmp
    ans += a - tmp
print(ans + tmp//b)