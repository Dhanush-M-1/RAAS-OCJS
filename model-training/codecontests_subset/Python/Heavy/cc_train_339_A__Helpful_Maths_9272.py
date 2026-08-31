x = input()
gk = 0
odin = 0
dva = 0
tri = 0
for i in range(len(x)):
    if x[i] == '1':
        odin += 1
    elif x[i] == '2':
        dva += 1
    elif x[i] == '3':
        tri += 1
    else:
        gk += 1
for t in range(odin):
    print(1, end='')
    if gk >= 1:
        gk -= 1
        print('+', end='')
for t1 in range(dva):
    print(2, end='')
    if gk >= 1:
        gk -= 1
        print('+', end='')
for t2 in range(tri):
    print(3, end='')
    if gk >= 1:
        gk -= 1
        print('+', end='')