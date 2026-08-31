n,m = [int(i) for i in input().split(" ")]
Lamps = [0]*m
for i in range(n):
    a = [int(x) for x in input().split(" ")][1:]
    for k in a:
        Lamps[k-1] = 1
if Lamps.count(1) == len(Lamps):
    print("YES")
else:
    print("NO")
