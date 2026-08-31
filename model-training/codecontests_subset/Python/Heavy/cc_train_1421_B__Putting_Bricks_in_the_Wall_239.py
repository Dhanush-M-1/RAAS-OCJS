for _ in range(int(input())):
    n=int(input())
    arr=[]
    for i in range(n):
        s=input()
        arr.append(s)
    if (arr[0][1]=='0' and arr[1][0]=='0' and arr[n-1][n-2]=='1' and arr[n-2][n-1]=='1') or (arr[0][1]=='1' and arr[1][0]=='1' and arr[n-1][n-2]=='0' and arr[n-2][n-1]=='0'):
        print('0')
    else:
        if arr[0][1]==arr[1][0] and arr[n-1][n-2]==arr[n-2][n-1] and arr[n-1][n-2]==arr[0][1]:
            print('2')
            print('1','2')
            print('2','1')
        elif arr[0][1]==arr[1][0]:
            if arr[n-1][n-2]==arr[0][1]:
                print('1')
                print(n,n-1)
            else:
                print('1')
                print(n-1,n)
        elif arr[n-1][n-2]==arr[n-2][n-1]:
            if arr[n-1][n-2]==arr[0][1]:
                print('1')
                print('1','2')
            else:
                print('1')
                print('2','1')
        else:
            if arr[1][0]==arr[n-2][n-1]:
                print('2')
                print('2','1')
                print(n,n-1)
            elif arr[0][1]==arr[n-2][n-1]:
                print('2')
                print('1','2')
                print(n,n-1)
                
        
