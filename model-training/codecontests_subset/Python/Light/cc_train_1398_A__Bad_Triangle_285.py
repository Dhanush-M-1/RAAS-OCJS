t = int(input())

for i in range(t):
    a = [-1]
    n=int(input())
    arr = list(map(int,input().split()))
    for j in range(2,n):
        if arr[0]+arr[1]<=arr[j]:
            a=[1,2,j+1]
    for item in a:
        print(item, end=" ")