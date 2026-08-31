a, b = [int(i) for i in input().split(' ')]
hours = 0
stubs = 0
while a > 0:
    a -= 1
    stubs += 1
    if stubs >= b:
        stubs -= b
        a += 1
    hours += 1
print(hours)