a, b = map(int, input().split())
res = a
while 1:
    res += a//b
    a = a//b + a%b
    if a < b:
        break
print(res) 