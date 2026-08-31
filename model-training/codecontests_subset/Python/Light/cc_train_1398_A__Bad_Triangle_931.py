t = int(input())
while t>0:
    t-=1
    n = int(input())
    arr = list(map(int,input().strip().split(" ")))
    
    a = arr[-1]
    b = arr[0]
    c = arr[1]
    
    if c+b > a:
        print(-1)
    else:
        print(1, 2, n)