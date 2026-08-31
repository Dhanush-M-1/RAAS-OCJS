
for _ in range(int(input())):
    n=int(input())
    a=[]
    for i in range(n):
        a.append(list(input()))
    c=0
    s=[]
    if (a[0][1]==a[1][0]) and (a[n-1][n-2]==a[n-2][n-1]):
        if a[0][1]!=a[n-1][n-2]:
            print(0)
        else:
            print(2)
            print('1 2')
            print('2 1')
    elif (a[0][1]==a[1][0]) and (a[n-1][n-2]!=a[n-2][n-1]):
        if a[n-1][n-2]==a[0][1]:
            print(1)
            print(f'{n} {n-1}')
        else:
            print(1)
            print(f'{n-1} {n}')
    elif (a[0][1]!=a[1][0]) and (a[n-1][n-2]==a[n-2][n-1]):
        if  a[n-1][n-2]==a[0][1]:
            print(1)
            print('1 2')
        else:
            print(1)
            print('2 1')
    else:
        print(2)
        if a[0][1]=='0':
            print('2 1')
        else:
            print('1 2')
        if a[n-1][n-2]=='1':
            print(f'{n-1} {n}')
        else:
            print(f'{n} {n-1}')
            
        
    
    
    
    
