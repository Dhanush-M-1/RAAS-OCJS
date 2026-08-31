a, b = map(int, input().split())
ans = a
left = 0
while(1):
    burn = a//b
    left += a%b
    a = burn
    if left>=b:
        a += 1
        left = left%b
    if a==0:
        break
    ans += a
print(ans)