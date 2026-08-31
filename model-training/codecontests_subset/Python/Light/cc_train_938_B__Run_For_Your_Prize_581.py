input()
l = list(map(int,input().split()))
distanceMax = 0
for e in l:
    distanceMin = e - 1
    distanceMin = min(distanceMin,1000000 - e)
    distanceMax = max(distanceMax,distanceMin)
print(distanceMax)

