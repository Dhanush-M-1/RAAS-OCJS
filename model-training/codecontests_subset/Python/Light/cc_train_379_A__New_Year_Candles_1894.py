a, b = map(int, input().split())
i = 1
count = 0
rez = 0
while a != 0:
    a = a - 1 + rez
    count += 1
    rez = 0
    if count % b == 0:
        rez = 1
        count = 0
    elif a == 0:
        break
    i += 1
print(i)







