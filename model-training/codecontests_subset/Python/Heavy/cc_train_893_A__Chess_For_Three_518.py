t = int(input())
c = [1,2]
for _ in range(t):
    p = int(input())
    if p == c[0]:
        if p == 1 and c[1]==2:
            c[1] = 3
        elif p==1 and c[1]==3:
            c[1] = 2
        elif p == 2 and c[1]==3:
            c[1] = 1
        elif p==2 and c[1] == 1:
            c[1] = 3
        elif p == 3 and c[1]==1:
            c[1] = 2
        elif p==3 and c[1] ==2:
            c[1] = 1
    elif p==c[1]:
        if p == 1 and c[0]==2:
            c[0] = 3
        elif p == 1 and c[0]==3:
            c[0] = 2
        elif p == 2 and c[0]==3:
            c[0] = 1
        elif p == 2 and c[0]==1:
            c[0] = 3
        elif p == 3 and c[0]==1:
            c[0] = 2
        elif p == 3 and c[0]==2:
            c[0] = 1
    else:
        print('NO')
        exit()
print('YES')
