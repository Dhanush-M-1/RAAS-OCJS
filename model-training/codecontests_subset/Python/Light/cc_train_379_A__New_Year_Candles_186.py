a, b = map(int, input().split())
count = a
while a // b != 0:
    count += a // b
    a = (a // b) + (a % b)
print(count)