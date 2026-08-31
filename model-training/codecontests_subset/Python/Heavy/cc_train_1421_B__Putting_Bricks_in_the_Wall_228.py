t=int(input())
for q in range(0,t):
    n=int(input())
    a=[]
    for i in range(0,n):
        a.append(list(input()))
    ans=[]
    if a[0][1]==a[1][0] and a[n-1][n-2]==a[n-2][n-1] and a[0][1]!=a[n-1][n-2]:
        print(0)
    elif a[0][1]==a[1][0] and a[n-1][n-2]!=a[n-2][n-1]:
        #print("h")
        if a[0][1]=='1' and a[n-1][n-2]=='1':
            print(1)
            print(n,n-1)
        elif a[0][1]=='1' and a[n-2][n-1]=='1':
            print(1)
            print(n-1,n)
        elif a[0][1]=='0' and a[n-1][n-2]=='0':
            print(1)
            print(n,n-1)
        elif a[0][1]=='0' and a[n-2][n-1]=='0':
            print(1)
            print(n-1,n)
    elif a[0][1] != a[1][0] and a[n - 1][n - 2] == a[n - 2][n - 1]:
        if a[0][1] == '1' and a[n - 1][n - 2] == '1':
            print(1)
            print(1,2)
        elif a[0][1] == '0' and a[n - 1][n - 2] == '0':
            print(1)
            print(1, 2)
        elif a[1][0] == '1' and a[n - 1][n - 2] == '1':
            print(1)
            print(2, 1)
        elif a[1][0] == '0' and a[n - 1][n - 2] == '0':
            print(1)
            print(2, 1)
    elif a[0][1]==a[1][0] and a[n-1][n-2]==a[n-2][n-1] and a[0][1]==a[n-1][n-2]:
        print(2)
        print(1,2)
        print(2,1)
    else:
        print(2)
        if a[0][1]!=a[n-1][n-2]:
            print(1,2)
            print(n,n-1)
        elif a[0][1]!=a[n-2][n-1]:
            print(1,2)
            print(n-1,n)
        elif a[1][0]!=a[n-1][n-2]:
            print(2,1)
            print(n,n-1)
        else:
            print(2,1)
            print(n-1,n)