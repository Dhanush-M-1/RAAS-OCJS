n, k = map(int,input().split())

a = list(map(int,input().split()))

minTime = 1000

for i in a:
    if k%i==0 and k/i<minTime:
        minTime = k/i
print(int(minTime))