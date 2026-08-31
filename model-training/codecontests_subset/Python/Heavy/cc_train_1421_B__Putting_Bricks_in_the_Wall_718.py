t = int(input())

for _ in range(t):
    n=int(input())
    l=[]
    kl=[]
    for i in range(n):
        l.append(input())
    kl.append(l[0][1])
    kl.append(l[1][0])
    kl.append(l[n-2][n-1])
    kl.append(l[n-1][n-2])
    i=0
    for op in  kl:
        if op=='0':
            i+=1
    if i==4:
        print(2)
        print('1 2')
        print('2 1')
    elif i==3:
        print(1)
        if kl[0]=='1':
            print('2 1')
        elif kl[1]=='1':
            print('1 2')
        elif kl[2]=='1':
            print(n, end=' ')
            print(n-1)
        elif kl[3]=='1':
            print(n-1, end=' ')
            print(n)
    elif i==2:
        if not kl[0]==kl[1]:
            print(2)
            print('1 2')
            if kl[0]==kl[2]:
                print(n, end=' ')
                print(n-1)
            else:
                print(n-1, end=' ')
                print(n)
        else:
            print(0)
    elif i==1:
        print(1)
        if kl[0]=='0':
            print('2 1')
        elif kl[1]=='0':
            print('1 2')
        elif kl[2]=='0':
            print(n, end=' ')
            print(n-1)
        elif kl[3]=='0':
            print(n-1, end=' ')
            print(n)
    elif i==0:
        print(2)
        print('1 2')
        print('2 1')