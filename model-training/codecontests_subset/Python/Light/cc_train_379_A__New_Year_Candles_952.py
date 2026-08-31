a, b = map(int,input().split())
count = 0
total = a
while a >= b:
    count = a // b
    total += count
    a = count + (a % b)
if a > b:
    total += a // b
    print(total)
else:
    print(total)