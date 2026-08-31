a, b = map(int, input().split())
num = a
while a>=b:
    t = a//b
    num += t
    a -= t*b
    a += t
print(num)