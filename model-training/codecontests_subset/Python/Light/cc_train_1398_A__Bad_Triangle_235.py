def no_triangle(arr):
    arr.sort()
    if arr[0]+arr[1]<=arr[-1]:
        l = [1,2,len(arr)]
    else:
        l = []
    return l
    
t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int,input().split()))
    result = no_triangle(arr)
    if result:
        print(*result,sep=" ")
    else:
        print(-1)