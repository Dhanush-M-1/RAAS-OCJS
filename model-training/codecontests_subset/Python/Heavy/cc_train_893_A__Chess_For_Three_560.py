a = 1
b = 2
c = 0
for _ in range(int(input())):
    n = int(input())
    if n==a:
        if a==1 and b==2:
            b = 3
        elif a==1 and b==3:
            b = 2
        elif a==2 and b==3:
            b = 1
        elif a==2 and b==1:
            b = 3
        elif a==3 and b==1:
            b = 2
        else:
            b = 1
    elif n==b:
        if a==1 and b==2:
            a = 3
        elif a==1 and b==3:
            a = 2
        elif a==2 and b==3:
            a = 1
        elif a==2 and b==1:
            a = 3
        elif a==3 and b==1:
            a = 2
        else:
            a = 1
    else:
        c = 1
        
if c==0:
    print('YES')
else:
    print('NO')