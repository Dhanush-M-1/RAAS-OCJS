t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().strip().split()))

    if(n==1):
        print("YES")
    else:
        if(n%2==1):
            flg=0
            mid=n//2
            for i in range(0,mid+1):
                if(arr[i]<i):
                    flg=1
                    break

            j=0
            for i in range(n-1,mid,-1):
                if(arr[i]<j):
                    flg=1
                    break
                j+=1
            if(flg==0):
                print("YES")
            else:
                print("NO")

        else:
            flg=0
            mid=n//2-1
            for i in range(mid):
                if(arr[i]<i):
                    flg=1
                    break
            x = arr[mid]
            y = arr[mid+1]

            j=0
            for i in range(n-1,mid+1,-1):
                if(arr[i]<j):
                    flg=1
                    break
                j+=1

            if(x>=n//2-1 and y>=n//2-1):
                if(x==n//2-1 or y==n//2-1):
                    if(x==y):
                        flg=1
            else:
                flg=1
            
            if(flg==0):
                print("YES")
            else:
                print("NO")
