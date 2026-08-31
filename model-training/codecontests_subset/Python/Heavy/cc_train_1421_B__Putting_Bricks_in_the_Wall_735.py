t=int(input())
for i in range(0,t):
    m=int(input())
    l=[]
    for j in range(0,m):
        str1=input()
        x=len(str1)
        l.append(str1)
    a=l[0][1]
    b=l[1][0]
    c=l[-2][-1]
    d=l[-1][-2]
    a=int(a)
    b=int(b)
    c=int(c)
    d=int(d)
    if(a==0 and b==0 and c==0 and d==0):
        print(2)
        print(1,2)
        print(2,1)
    elif(a==0 and b==0 and c==0 and d==1):
        print(1)
        print((m-1),x)
    elif(a==0 and b==0 and c==1 and d==0):
        print(1)
        print(m,(x-1))
    elif(a==0 and b==0 and c==1 and d==1):
        print(0)
    elif(a==0 and b==1 and c==0 and d==0):
        print(1)
        print(1,2)
    elif(a==0 and b==1 and c==0 and d==1):
        print(2)
        print(1,2)
        print(m,(x-1))
    elif(a==0 and b==1 and c==1 and d==0):
        print(2)
        print(2,1)
        print(m,(x-1))
    elif(a==0 and b==1 and c==1 and d==1):
        print(1)
        print(2,1)
    elif(a==1 and b==0 and c==0 and d==0):
        print(1)
        print(2,1)
    elif(a==1 and b==0 and c==0 and d==1):
        print(2)
        print(1,2)
        print((m-1),x)
    elif(a==1 and b==0 and c==1 and d==0):
        print(2)
        print(2,1)
        print((m-1),x)
    elif(a==1 and b==0 and c==1 and d==1):
        print(1)
        print(1,2)
    elif(a==1 and b==1 and c==0 and d==0):
        print(0)
    elif(a==1 and b==1 and c==0 and d==1):
        print(1)
        print(m,(x-1))
    elif(a==1 and b==1 and c==1 and d==0):
        print(1)
        print((m-1),x)
    elif(a==1 and b==1 and c==1 and d==1):
        print(2)
        print(1,2)
        print(2,1)
        
        