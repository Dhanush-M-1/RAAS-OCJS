t = int(input())

while t > 0:
    n = int(input())
    # s = input()
    # n, m = map(int, input().split())
    a = list(map(int, input().split()))
    # b = list(map(int, input().split()))
    
    i = 0
    k = n-1
    j = -1
    for it in range(1,n-1):
        if a[i]+a[it]<=a[k]:
            j = it
            break
    if j == -1:
        print(-1)
    else:
        print(i+1,j+1,k+1)
    
    t -= 1