n = int(input())
spec = 3
err = 0
for i in range(n):
    win = int(input())
    if err == 0:
        if spec == 3:
            if win == 1: spec = 2
            elif win == 2: spec = 1
            else:
                print('NO')
                err = 1
        elif spec == 2:
            if win == 1: spec = 3
            elif win == 3: spec = 1
            else:
                print('NO')
                err = 1
        elif spec == 1:
            if win == 3: spec = 2
            elif win == 2: spec = 3
            else:
                print('NO')
                err = 1
        else:
            print('NO')
            err = 1
if err == 0: print('YES')