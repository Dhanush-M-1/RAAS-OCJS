a, b = map(int, input().split())
sum = a
while (a >= b):
    div = a // b
    sum = sum + div
    rem = a % b
    a = div + rem

print(sum)
