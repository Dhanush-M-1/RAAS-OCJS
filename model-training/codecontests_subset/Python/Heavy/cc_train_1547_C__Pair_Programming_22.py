for _ in range(int(input())):
    waste = input()
    k,n,m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    
    lim = 700; flag = 0
    ans = []
    i = 0; j = 0
    while i<len(a) or j<len(b):
        while i<len(a) and a[i]<=k:
            if a[i]==0: k+=1
            ans.append(a[i])
            i+=1

        while j<len(b) and b[j] <= k:
            if b[j]==0: k+=1
            ans.append(b[j])
            j+=1
        lim-=1
        if lim==0: flag = 1 ; break

    print(*ans) if flag == 0 else print(-1)
