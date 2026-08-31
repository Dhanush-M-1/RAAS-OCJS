a, b = list(map(int, input().split()))
count = a
while a >= b:
    remaining = a // b
    count += remaining
    remainder = a % b
    a = remaining + remainder
print(count)