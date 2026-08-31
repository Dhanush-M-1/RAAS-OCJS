a, b = map(int, input().split())
total = 0
left = 0
while a != 0:
    total += a
    left += a
    a = left // b
    left -= a*b

print(total)
