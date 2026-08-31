a, b = map(int, input().split(' '))
ans, rem = 0, 0
while a > 0:
    ans += a
    a += rem
    rem = a%b
    a //= b
print(ans)
