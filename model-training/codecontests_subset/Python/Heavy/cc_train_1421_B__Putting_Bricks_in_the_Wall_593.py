nn = int(input())
mm = []
for _ in range(nn):
    n = int(input())
    mm.append([])
    for _ in range(n): 
        s = input()
        mm[-1].append(s)

for i in range(nn):
    m = mm[i]
    n = len(m)
    a, b, c, d = int(m[0][1]), int(m[1][0]), int(m[-1][-2]), int(m[-2][-1])
    if (a == b == 0 and c == d == 1) or (a == b == 1 and c == d == 0):
        print(0)
    elif (a == b == c == d == 0) or (a == b == c == d == 1):
        print(2)
        print('1 2')
        print('2 1')
    elif a + b == 1 and c + d == 2:
        print(1)
        if a == 1:
            print('1 2')
        else:
            print('2 1')
    elif a + b == 1 and c + d == 0:
        print(1)
        if a == 0:
            print('1 2')
        else:
            print('2 1')
    elif a + b == 1 and c + d == 1:
        print(2)
        if a == 1:
            print('1 2')
        else:
            print('2 1')
        if c == 0:
            print('{} {}'.format(n, n-1))
        else:
            print('{} {}'.format(n-1, n))
    elif c + d == 1 and a + b == 2:
        print(1)
        if c == 1:
            print('{} {}'.format(n, n-1))
        else:
            print('{} {}'.format(n-1, n))
    elif c + d == 1 and a + b == 0:
        print(1)
        if c == 0:
            print('{} {}'.format(n, n-1))
        else:
            print('{} {}'.format(n-1, n))