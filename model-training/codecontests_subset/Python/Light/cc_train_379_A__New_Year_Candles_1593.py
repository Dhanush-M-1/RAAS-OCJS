a, b = [int(a) for a in input().split()]
count = a
while a >= 1:
    a /= b
    count += a
print(int(count))