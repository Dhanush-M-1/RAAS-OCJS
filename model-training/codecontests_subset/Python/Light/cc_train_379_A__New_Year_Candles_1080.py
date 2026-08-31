s = input()
s1 = s.split(' ')
a = int(s1[0])
b = int(s1[1])
day = 0

while a != 0:
    a = a - 1
    day += 1
    if day % b == 1:
        day += 1
print(day - 1)

