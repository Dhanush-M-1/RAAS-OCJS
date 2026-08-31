for _ in range(int(input())):
    n = int(input())
    r = list(map(int, input().split()))
    c = list(map(int, input().split()))
    arr = sorted(list(zip(r,c)))
    correction = (1,1)
    ans = 0
    check = True
    for point in arr:
        r,c = point[0]-correction[0]+1, point[1]-correction[1]+1
        depth = r-1
        if(r==c):
            if(check):
                ans += depth
        else:
            if(not check):
                ans += 1
            ans += (r-c-int(not check))//2
        correction = point
        if((r+c)%2!=0):
            check = not check
    print(ans)
        
    
        