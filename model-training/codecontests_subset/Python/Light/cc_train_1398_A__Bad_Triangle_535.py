t=int(input())
for i in range(t):
    n=int(input())
    arr=[int(x) for x in input().split()]
    
    x=arr[0]+arr[1]
    flag=False
    for i in range(2,n):
        if arr[i]>=x:
            flag=True
            print(1,2,i+1)
            break
    if flag==False:
        print(-1)