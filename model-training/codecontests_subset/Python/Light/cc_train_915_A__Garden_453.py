n, k = [int(x) for x in input().split()]
good = []
for i in [int(x) for x in input().split()]:
    if k % i == 0:
        good.append(i)
print(k // max(good))