a, b = map(int, input().split())
e = a
while a >= b:
    e += a//b
    a = a//b + a%b
print(e)