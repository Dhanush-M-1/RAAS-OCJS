t = int(input())
for j in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    stable_max = 0
    max_val = -1
    min_val = 10**9
    for i in range(len(a)-1):
        if (a[i] == -1) ^ (a[i+1] == -1):
            num = max(a[i],a[i+1])
            max_val = max(max_val,num)
            min_val = min(min_val,num)
        if a[i] != -1 and a[i+1] != -1:
            stable_max = max(stable_max,abs(a[i]-a[i+1]))
    if max_val == -1:
        print(0,1)
    else:
        ans = max_val + min_val
        ans //= 2
        diff = max(max_val-ans,ans-min_val,stable_max)
        print(diff,ans)
        