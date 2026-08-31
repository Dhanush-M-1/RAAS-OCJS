a, b = map(int,input().strip().split())
r = a
rem = 0
while a > 0:
    a += rem
    s = a // b
    r += s
    rem = a % b
    a = s
print(r)

    