a,b = list(map(int, input().split()))
s = 0
x = 0
while a != 0:
    while a > 0:
        x += (a%b)
        s += a
        a = a//b
    a = x//b
    x = x%b
print(s)
