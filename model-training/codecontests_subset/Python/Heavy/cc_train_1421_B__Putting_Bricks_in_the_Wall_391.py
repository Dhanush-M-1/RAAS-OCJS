import math
t=int(input())
for w in range(t):
    n=int(input())
    l=[]
    for i in range(n):
        l.append(list(input()))
    c=0
    l1=[]
    if(l[0][1]=='0' and l[1][0]=='0'):
        if(l[-1][-2]=='0'):
            c+=1
            l1.append((n,n-1))
        if(l[-2][-1]=='0'):
            c+=1
            l1.append((n-1,n))
    elif(l[0][1]=='1' and l[1][0]=='1'):
        if(l[-1][-2]=='1'):
            c+=1
            l1.append((n,n-1))
        if(l[-2][-1]=='1'):
            c+=1
            l1.append((n-1,n))
    elif(l[0][1]=='0' and l[1][0]=='1'):
        if(l[-1][-2]=='0' and l[-2][-1]=='0'):
            c+=1
            l1.append((1,2))
        elif(l[-1][-2]=='1' and l[-2][-1]=='1'):
            c+=1
            l1.append((2,1))
        elif(l[-1][-2]=='0' and l[-2][-1]=='1'):
            c+=2
            l1.append((1,2))
            l1.append((n-1,n))
        else:
            c+=2
            l1.append((1,2))
            l1.append((n,n-1))
    else:
        if(l[-1][-2]=='0' and l[-2][-1]=='0'):
            c+=1
            l1.append((2,1))
        elif(l[-1][-2]=='1' and l[-2][-1]=='1'):
            c+=1
            l1.append((1,2))
        elif(l[-1][-2]=='0' and l[-2][-1]=='1'):
            c+=2
            l1.append((2,1))
            l1.append((n-1,n))
        else:
            c+=2
            l1.append((2,1))
            l1.append((n,n-1))
    print(c)
    for i in l1:
        print(i[0],i[1])