a, b = input().split()
a = int(a)
b = int(b)
ans = 0
cnt = 0
while a > 0:
    ans += 1
    a -= 1
    cnt += 1
    if cnt == b:
        cnt = 0
        a += 1
print(ans)
