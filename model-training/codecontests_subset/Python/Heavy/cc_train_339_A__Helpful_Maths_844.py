string = input()
count1 = int(0)
count2 = int(0)
count3 = int(0)
for i in string:
    if i == '1':
        count1 += 1
    elif i == '2':
        count2 += 1
    elif i == '3':
        count3 += 1
for i in range(count1 - 1):
    print(1, end="+")
if count1 > 0:
    print(1, end="")
if (count2 > 0 or count3 > 0) and (count1 > 0):
    print('+', end="")
for i in range(count2 - 1):
    print(2, end="+")
if count2 > 0:
    print(2, end="")
if count3 > 0 and count2 > 0:
    print('+', end="")
for i in range(count3 - 1):
    print(3, end="+")
if count3 > 0:
    print(3)