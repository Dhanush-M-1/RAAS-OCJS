ab = input().split()
a = int(ab[0])
b = int(ab[1])
ans = a
while a//b != 0:
    ans += a//b
    a = a//b + a%b
print(ans)
