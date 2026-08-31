a, b = map(int,input().split())
s = 0
s += a
if (a // b) > 0:
    while a >= b:
        t = a % b
        a //= b
        s += a
        a += t 
print(s)