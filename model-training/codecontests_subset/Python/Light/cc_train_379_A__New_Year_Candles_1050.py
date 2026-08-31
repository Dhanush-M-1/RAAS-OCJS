a, b = tuple(map(int, input().split()))
spent = a
hours = a
while spent >= b:
    spent -= b
    hours += 1
    spent += 1
print(hours)
