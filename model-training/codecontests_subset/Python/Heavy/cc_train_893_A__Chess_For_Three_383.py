import sys
n=int(input())
s='12'
t=[1,2,3]
l=[1,1,0]
for i in range(n):
    k=int(input())
    if k==1:
        if l[0]==0:
            print('NO')
            sys.exit()
        l[0]=1
        if l[1]==1:
            l[2]=1
            l[1]=0
        else:
            l[2]=0
            l[1]=1
    elif k==2:
        if l[1]!=1:
            print('NO')
            sys.exit()
        if l[0]==1:
            l[2]=1
            l[0]=0
        else:
            l[2]=0
            l[0]=1
    else:
        if l[2]!=1:
            print('NO')
            sys.exit()
        if l[0]==1:
            l[0]=0
            l[1]=1
        else:
            l[0]=1
            l[1]=0
print('YES')
            
