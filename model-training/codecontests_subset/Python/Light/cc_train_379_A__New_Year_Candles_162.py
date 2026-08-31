a, b = map(int, input().split())
s = a
while a // b > 0:
    s += a // b
    a = sum(divmod(a, b))
print(s)
