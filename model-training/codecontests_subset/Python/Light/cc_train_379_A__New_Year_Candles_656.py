a, b = map(int,input().split())
s = 0
i = 0
while a > 0:
    s = s + a
    i = i % b
    i = i + a % b
    a = a // b + i //b
print(s)