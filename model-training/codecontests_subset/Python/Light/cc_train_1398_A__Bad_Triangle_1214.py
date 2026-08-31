t = int(input())
while t > 0:
    n = int(input())
    arr = list(map(int , input().split()))
    flag = True
    if arr[0] + arr[1] > arr[-1]:
        print(-1)
    else:
        print(1,2,n)
    t -= 1