x,y = map(int, input().split())
buckets = [int(i) for i in input().split()]
houre = 0
q = 0
for i in buckets:
    if (y % i) == 0:
        q = i
    if houre == 0:
        houre = q
    elif (y / q) < (y / houre):
        houre = q
z = y / houre
print(int(z))