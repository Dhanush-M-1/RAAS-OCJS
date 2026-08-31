a, b = list(map(int, input().split()))
hours = a
ost = 0
while a > 0:
    a2 = a + ost
    a = (a+ost) // b
    ost = a2 % b
    hours += a
print(hours)