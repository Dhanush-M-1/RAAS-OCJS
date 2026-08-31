a, b = map(int, input().split())
ans = a
while a >= b:
    ans+=int(a/b)
    a = int(a / b) + a % b
print(ans)
