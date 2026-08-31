t = int(input())
for j in range(t):
    n = int(input())
    a = ['0'] * n
    for i in range(n):
        a[i] = str(input())
        a[i] = list(a[i])
    if a[0][1] == a[1][0]:
        if a[n - 1][n - 2] == a[n - 2][n - 1]:
            if a[0][1] == a[n - 1][n - 2]:
                print(2)
                if a[0][1] == '0':
                    print(0+1,1+1)
                    print(1+1,0+1)
                else:
                    print(0+1,1+1)
                    print(1+1,0+1)
            else:
                print(0)
        else:
            print(1)
            if a[0][1] =='0':
                if a[n - 1][n - 2] == '0':
                    print(n - 1+1,n - 2+1)
                else:
                    print(n - 2+1, n - 1+1)
            else:
                if a[n - 1][n - 2] == '1':
                    print(n - 1+1,n - 2+1)
                else:
                    print(n - 2+1, n - 1+1)
    else:
        if a[n - 1][n - 2] == a[n - 2][n - 1]:
                if a[n - 1][n - 2] == '0':
                    print(1)
                    if a[0][1] == '0':
                        print(0+1,1+1)
                    else:
                        print(1+1, 0+1)
                else:
                    print(1)
                    if a[0][1] == '1':
                        print(0+1,1+1)
                    else:
                        print(1+1,0+1)
        else:
            print(2)
            if a[0][1] != a[n - 1][n - 2]:
                print(0+1,1+1)
                print(n - 1+1,n - 2+1)
            else:
                print(0+1,1+1)
                print(n - 2+1,n - 1+1)
                         
    
            
