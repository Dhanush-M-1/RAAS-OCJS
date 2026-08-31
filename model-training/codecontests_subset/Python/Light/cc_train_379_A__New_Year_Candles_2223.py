a = list(input().split())
c = 0
hours = 0
while c < int(a[0]):
    if int(a[0]) < int(a[1]):
        hours += int(a[0])
        break
    c = int(a[0]) - int(a[1])
    a[0] = str(c + 1)
    hours += int(a[1])
print(hours)