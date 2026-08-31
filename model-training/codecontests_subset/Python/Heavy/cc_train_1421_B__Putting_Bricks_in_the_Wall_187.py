t=int(input())
for _ in range(t):
    n=int(input())
    row=[None]*n
    for i in range(n):
        row[i]=input()
    (a_1,a_2) = ([row[0][1], row[1][0]], [row[n-2][n-1], row[n-1][n-2]])
    if a_1==['0','0']:
        c=2-a_2.count('1')
        print(c)
        if c!=0:
            if a_2[0]!='1':
                print(f'{n-1} {n}')
            if a_2[1]!='1':
                print(f'{n} {n-1}')
    elif a_1==['1','1']:
        c=2-a_2.count('0')
        print(c)
        if c!=0:
            if a_2[0]!='0':
                print(f'{n-1} {n}')
            if a_2[1]!='0':
                print(f'{n} {n-1}')
    elif a_2==['0','0']:
        c=2-a_1.count('1')
        print(c)
        if c!=0:
            if a_1[0]!='1':
                print('1 2')
            if a_1[1]!='1':
                print('2 1')
    elif a_2==['1','1']:
        c=2-a_1.count('0')
        print(c)
        if c!=0:
            if a_1[0]!='0':
                print('1 2')
            if a_1[1]!='0':
                print('2 1')
    else:
        print(2)
        print('1 2')
        if a_1[0]!=a_2[0]:
            print(f'{n-1} {n}')
        else:
            print(f'{n} {n-1}')
    
        