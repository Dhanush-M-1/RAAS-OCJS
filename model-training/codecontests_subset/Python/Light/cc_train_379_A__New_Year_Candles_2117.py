ab = list(map(int, input().split()))
a = ab[0]
b = ab[1]
s = a
while int(a/b) != 0:
    r = a%b
    a = int(a/b)
    s += a
    a += r
print(s)