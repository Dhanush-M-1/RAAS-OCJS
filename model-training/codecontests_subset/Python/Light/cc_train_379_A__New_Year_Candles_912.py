a, b = map(int, input().split())
it = a
r = 0
while a >= b:
    r = a % b
    a = a // b
    it += a
    a += r
print(it)

