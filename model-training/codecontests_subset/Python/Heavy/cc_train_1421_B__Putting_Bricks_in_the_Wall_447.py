for t in range(int(input())):
    n=int(input())
    arr=[]
    for i in range(n):
        row=list(input())
        arr.append(row)
    d1=[int(arr[1][0]),int(arr[0][1])]
    d2=[int(arr[n-1][n-2]),int(arr[n-2][n-1])]
    if d1==[0,0]:
        if d2==[0,0]:
            print(2)
            print(2,1)
            print(1,2)
        elif d2==[1,0]:
            print(1)
            print(n-1,n)
        elif d2==[0,1]:
            print(1)
            print(n,n-1)
        else:
            print(0)
    elif d1==[1,0]:
        if d2==[0,0]:
            print(1)
            print(1,2)
        elif d2==[1,0]:
            print(2)
            print(2,1)
            print(n,n-1)
        elif d2==[0,1]:
            print(2)
            print(1,2)
            print(n-1,n)
        elif d2==[1,1]:
            print(1)
            print(2,1)
    elif d1==[0,1]:
        if d2==[0,0]:
            print(1)
            print(2,1)
        elif d2==[1,0]:
            print(2)
            print(1,2)
            print(n-1,n)
        elif d2==[0,1]:
            print(2)
            print(1,2)
            print(n,n-1)
        elif d2==[1,1]:
            print(1)
            print(1,2)
    elif d1==[1,1]:
        if d2==[0,0]:
            print(0)
        elif d2==[1,0]:
            print(1)
            print(n,n-1)
        elif d2==[0,1]:
            print(1)
            print(n-1,n)
        elif d2==[1,1]:
            print(2)
            print(n-1,n)
            print(n,n-1)