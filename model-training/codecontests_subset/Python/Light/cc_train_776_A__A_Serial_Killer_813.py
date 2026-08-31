a, b = input().split()

for i in range(int(input())):
    print(a, b)
    c, d = input().split()
    if d != a and d != b:
        c, d = d, c
    if a != d:
        a, b = b, a
    a = c

print(a, b)