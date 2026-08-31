__author__ = 'widoc'


a, b = map(int, input().split())
res = 0
rest = 0
while a > 0:
    res += a
    if a >= b:
        rest += a % b
        a = a // b
    elif a + rest >= b:
        old_a = a
        a = (a + rest) // b
        rest = (old_a + rest) % b
    else:
        # res += a
        break

print(res)

