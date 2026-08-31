s = input()
k1, k2, k3 = [0,0,0]
for i in range(0,len(s),2):
    if s[i] == '1':
        k1 += 1
    if s[i] == '2':
        k2 += 1
    if s[i] == '3':
        k3 += 1
if (k2 != 0 or k3 != 0):
    for i in range(k1):
        print('1+', end='')
else:
    for i in range(k1 - 1):
        print('1+', end='')
    print('1', end='')
if (k3 != 0):
    for i in range(k2):
        print('2+', end='')
else:
    if k2 > 1:
        for i in range(k2 - 1):
            print('2+', end='')
        print('2', end='')
    else:
        if k2 == 1:
            print('2', end='')
if k3 > 1:
    for i in range(k3 - 1):
        print('3+', end='')
    print('3', end='')
else:
    if k3 == 1:
        print('3', end='')
