def badtri(arr):
    last=arr[-1]
    for i in range(len(arr)-2):
        diff=last-arr[i]
        if arr[i+1]<=diff:
            return (i+1,i+2,len(arr))
    return (-1,)
    
t=int(input())
for i in range(t):
    n=int(input())
    arr=[int(k) for k in input().split()]
    print(*badtri(arr))