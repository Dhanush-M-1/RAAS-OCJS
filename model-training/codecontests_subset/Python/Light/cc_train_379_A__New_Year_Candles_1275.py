a, b = map(int, input().split())
count = a

while(1):
    d = a // b
    count += d
    rem = a % b
    a = d + rem
    if a < b:
        break

print(count)