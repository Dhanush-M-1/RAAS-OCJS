for _ in range(int(input())):
    n=int(input())
    arr=list(map(int,input().split()))
    x=arr[0]
    y=arr[1]
    z=arr[n-1]
    if x+y<=z:
        print(1,2,n)
    else:
        print(-1)
        
                    
                
