import sys

a, b = input().split()
print(a, b)
x, y = a, b

n = int(input())
for i in range(n):
    a, b = input().split()
    if a == x or a == y:
        if a == x:
            x = b
        else:
            y = b
    else:
        if b == x:
            x = a
        else:
            y = b

    print(x, y)
