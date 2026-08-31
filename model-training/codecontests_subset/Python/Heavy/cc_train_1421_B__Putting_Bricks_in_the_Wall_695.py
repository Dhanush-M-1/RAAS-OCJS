for _ in range(int(input())):
    n=int(input())
    mat=[]
    for i in range(n):
        temp=input()
        temp=list(temp)
        mat.append(temp)
    a=int(mat[0][1])
    b=int(mat[1][0])
    x=int(mat[n-1][n-2])
    y=int(mat[n-2][n-1])
    if (a==b==0 and x==y==1) or (a==b==1 and x==y==0):
        print(0)
    elif  (a==b==0 and x==0 and y==1):
        print(1)
        print(n,n-1)
    elif  (a==b==0 and x==1 and y==0):
        print(1)
        print(n-1,n)
    elif  (a==b==0 and x==0 and y==0):
        print(2)
        print(n,n-1)
        print(n-1,n)


    elif  (a==1 and b==0 and x==0 and y==0):
        print(1)
        print(2,1)
    elif  (a==1 and b==0 and x==1 and y==0):
        print(2)
        print(2,1)
        print(n,n-1)
    elif  (a==1 and b==0 and x==0 and y==1):
        print(2)
        print(2,1)
        print(n-1,n)
    elif  (a==1 and b==0 and x==1 and y==1):
        print(1)
        print(1,2)
    
    elif  (a==0 and b==1 and x==0 and y==0):
        print(1)
        print(1,2)
    elif  (a==0 and b==1 and x==1 and y==0):
        print(2)
        print(2,1) #b
        print(n-1,n) #y
    elif  (a==0 and b==1 and x==0 and y==1):
        print(2)
        print(2,1)
        print(n,n-1)
    elif  (a==0 and b==1 and x==1 and y==1):
        print(1)
        print(2,1)
    
    elif  (a==1 and b==1 and x==1 and y==0):
        print(1)
        print(n,n-1)
    elif  (a==1 and b==1 and x==0 and y==1):
        print(1)
        print(n-1,n)
    elif  (a==1 and b==1 and x==1 and y==1):
        print(2)
        print(1,2)
        print(2,1)