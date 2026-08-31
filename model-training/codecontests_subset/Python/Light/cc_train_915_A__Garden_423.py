n,k = map(int,input().split())
a = sorted(list(map(int,input().split())))
hours = 0

for x in a:
    if x > k:
        break
    elif k % x == 0:
        hours = x
print(k // hours)