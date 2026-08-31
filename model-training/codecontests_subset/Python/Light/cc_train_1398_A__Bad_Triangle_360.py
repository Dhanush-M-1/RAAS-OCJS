t=int(input())
for _ in range(t):
    n=int(input())
    arr=input().split()
    for i in range(n):
        arr[i]=int(arr[i])
    if arr[0]+arr[1]<=arr[-1]:
        print("1 2 "+str(n))
    else:
        print("-1")    