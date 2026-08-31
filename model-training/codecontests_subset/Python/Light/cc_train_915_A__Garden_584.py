n, k = map(int, input().split())
l = [int(x) for x in input().split()]
mx = 0

for i in range(n):
    if k % l[i] != 0:
        l[i] = 0
        

print(k//max(l))