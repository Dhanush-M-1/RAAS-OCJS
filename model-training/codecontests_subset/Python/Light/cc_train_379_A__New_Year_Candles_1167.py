a = [int(x) for x in input().split()]
burnt = 0
remainder = 0
x = 0
while a[0] != 0:
    x += a[0]
    burnt = remainder + a[0]
    a[0] = burnt//a[1]
    remainder = burnt % a[1]
print(x)