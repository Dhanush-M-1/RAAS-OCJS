n=int(input())
l=[int(i) for i in input().split()]
dist=[0]*10000000
for i in l:
    dist[i]=min(i-1,10**6-i)
print(max(dist))