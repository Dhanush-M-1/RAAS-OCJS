a, b = list(map(int, input().split()))
hours = a

while a != 1:
    if a % b == 0:
        hours += a // b
        a //= b
    elif a > b and a % b != 0:
        hours += a // b
        a = a // b + a % b
    elif a < b:
        break
print(hours)
