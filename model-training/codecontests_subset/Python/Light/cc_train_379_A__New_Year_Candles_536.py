a, b = input().split()
a = int(a)
b = int(b)
sum = a
while a // b != 0:
    sum = sum + (a // b)
    a = (a // b) + (a % b)
print(sum)
