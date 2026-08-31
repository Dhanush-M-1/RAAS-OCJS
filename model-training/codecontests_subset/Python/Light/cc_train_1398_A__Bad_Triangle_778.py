for _ in range(int(input())):
    n = int(input())
    s = list(map(int,input().split()))

    k = s[0] + s[1]
    if k <= s[-1]:
        print(1,2,n)
    else:
        print(-1)
        
        
