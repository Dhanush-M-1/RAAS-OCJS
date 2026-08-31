t = int(input())

for i in range(t):
    s = int(input()) 
    arr = list(map(int, input().split()))
    if ((arr[0]+arr[1])<=arr[-1]):
        print(1,2,s)
    else:
        print("-1")
    