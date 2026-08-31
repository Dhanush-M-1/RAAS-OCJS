a = input().split(' ')
b, a = int(a[1]), int(a[0])
hours = 0
remain = 0

while a != 0:
    hours += a
    remain += a
    a -= a
    if remain >= b:
        a += remain//b
        remain = remain % b
print(hours)