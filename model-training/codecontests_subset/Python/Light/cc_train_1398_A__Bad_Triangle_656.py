def badTriangle(arr):
    if arr[0] + arr[1] in arr:
        print(*[1,2, arr.index(arr[0]+arr[1])+1])
    elif arr[0] + arr[1] <= arr[-1]:
        print(*[1,2,len(arr)])
    else:
        print(-1)
        
tc = int(input())
for i in range(tc):
    n = int(input())
    a = list(map(int, input().split()))
    badTriangle(a)