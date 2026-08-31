from collections import defaultdict,Counter
n,k = map(int,input().split())
List = [int(x) for x in input().split()]
List.sort()
count = Counter(List)
for i in count.keys():
    if(count[i]>=k):
        print(0)
        exit()
reached = [0] * 200001
cost = [0] * 200001
for i in range(n):
    val = List[i]
    curr_cost = 0
    while(val):
        val>>=1
        curr_cost += 1
        if(reached[val]<k-count[val]):
            cost[val] += curr_cost
            reached[val] += 1
ans = 10000000000
for i in range(200001):
    if(reached[i] == k-count[i]):
        ans = min(ans,cost[i])
print(ans)

