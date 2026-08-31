a = input().strip().split('+')
c_1 = 0
c_2 = 0
c_3 = 0
for i in a:
    if i == "1":
        c_1 += 1
    elif i == "2":
        c_2 += 1
    else:
        c_3 += 1
c = c_2 + c_1 + c_3
if c == 1:
    print(a[0])
else:
    for i in range(c_1):
        print(1, end='')
        c -= 1
        if c != 0:
            print('+', end='')
    for i in range(c_2):
        print(2, end='')
        c -= 1
        if c != 0:
            print('+', end='')
    for i in range(c_3):
        print(3, end='')
        c -= 1
        if c != 0:
            print('+', end='')