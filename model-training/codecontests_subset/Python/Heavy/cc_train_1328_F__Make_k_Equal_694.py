from collections import defaultdict as dfd

n, k = map(int, input().split())
arr = list(map(int, input().split()))

d = dfd(int)
##cost = dfd(int)
value = None
ans = 999999999
cost = [[] for i in range(max(arr)+1)]
for i in arr:
    #uss element ke liye
    d[i] += 1
    cost[i].append(0)
    
##    if d[i]>=k:
##        cost[i].sort()
##        ans = min(ans, sum(cost[:k]))
        
    j = i
    propogate = 0
    while j>0:
        j //= 2
        d[j] += 1
        propogate += 1
        cost[j].append(propogate)
##        
##        if d[j]>=k:
##            cost[j].sort()
##            ans = min(ans, sum(cost[:k]))
            
##    print(d)
##    print(cost)
##    print("-------------------")
for i, j in d.items():
    if j>=k:
        cost[i].sort()
        ans = min(ans, sum(cost[i][:k]))
print(ans)
