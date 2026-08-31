a, b = map(int, input().split())
ans = 0
tmp = 0
while True:
    ans += a
    tmp += a
    if tmp<b:break
    a = tmp//b
    tmp = tmp%b
print(ans)