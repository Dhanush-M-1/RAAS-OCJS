numbers = list(map(int,input().split()))
a = numbers[0]
b = numbers[1]

hours = a
rest = a
while (a != 0):
    a = rest//b
    hours += a
    rest = a + rest%b

print(hours)
