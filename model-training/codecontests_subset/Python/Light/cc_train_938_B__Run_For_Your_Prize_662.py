n = int(input())
p1 = -1
p2 = 1000005
pre = [int(i) for i in input().split()]
for x in pre :
    if x <= 500000 :
        p1 = max(p1, x)
    else :
        p2 = min(p2, x)
if p1 == -1 :
    print(1000000 - p2)
elif p2 == 1000005 :
    print(p1 -1)
else :
    print(max(p1 - 1, 1000000 - p2))