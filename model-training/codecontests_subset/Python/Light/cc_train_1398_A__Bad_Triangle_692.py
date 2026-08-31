#code By Abhishek
def solve(arr,n):
    for i in range(2,n):
        if arr[0] + arr[1]<=arr[i]:
            print(1,2,i+1)
            return
    print(-1)
    return

for _ in range(int(input())):   
    n=int(input())
    arr=list(map(int,input().split()))
    solve(arr,n)