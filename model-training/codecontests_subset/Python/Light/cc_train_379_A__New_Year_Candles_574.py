a, b = map(int, input().split())
ans = 0
star = a
while a > 0:
    ans += a
    a = star // b
    star = star % b
    star = star + a
    

print(ans)