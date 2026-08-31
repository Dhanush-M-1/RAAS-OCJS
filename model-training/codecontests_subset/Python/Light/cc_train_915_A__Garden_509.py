vals = input()
vals = vals.strip()
n = int(vals.split()[0])
k = int(vals.split()[1])
bucks = input()
buckets = bucks.strip().split()
minVal = k
for x in range(n):
    if k % int(buckets[x]) == 0:
        minBuck = k / int(buckets[x])
        if minVal > minBuck:
            minVal = minBuck



print (int(minVal))