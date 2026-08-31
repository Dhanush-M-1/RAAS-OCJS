n=input()
if(len(n)==1):
    print(n)
else:
    a=n.count('1')
    b=n.count('2')
    c=n.count('3')
    for i in range(a):
        if((b==0)and(c==0)and(i==a-1)):
            print('1',end='')
        else:
            print('1','+',sep='',end='')
    for i in range(b):
        if((c==0)and(i==b-1)):
            print('2',end='')
        else:
            print('2','+',sep='',end='')
    for i in range(c):
        if(i==c-1):
            print('3',end='')
        else:
            print('3','+',sep='',end='')