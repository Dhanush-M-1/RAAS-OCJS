 
t=int(input())
for i in range(t):
    N=int(input())
    arr = [int(x) for x in input().split()]
    if arr[0]+arr[1]<=arr[-1]:
        print(1,2,N)
    else:
        
        print(-1)
