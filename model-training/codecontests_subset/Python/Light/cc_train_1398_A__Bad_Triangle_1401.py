t=int(input())
for _ in range(t):
    n=int(input())
    arr=[int(x) for x in input().split()]
    total=arr[0]+arr[1]
    j=0
    for i in range(2,n):
        if arr[i] >= total:
            j=i+1
            break
    if j == 0:
        print("-1")
    else:
        print('1 2',j)