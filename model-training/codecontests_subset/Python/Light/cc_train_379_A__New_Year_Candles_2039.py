a, b = map(int, input().split())
ch = 0
f = 0
while a != 0:
    a -= 1
    ch += 1
    f += 1
    if f == b:
        a += 1
        f -= b
print(ch)