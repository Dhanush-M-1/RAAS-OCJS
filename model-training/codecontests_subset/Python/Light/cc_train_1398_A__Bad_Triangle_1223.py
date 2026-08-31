t=int(input())
for test in range(t):
    n=int(input())
    arr=[int(x) for x in input().split()]
    if arr[0] +arr[1] <= arr[n-1]:
        print(1,2,n)
    else:
        print(-1)