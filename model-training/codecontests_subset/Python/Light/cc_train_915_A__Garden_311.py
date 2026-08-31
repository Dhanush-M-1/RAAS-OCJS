n, k = [int(x) for x in input().split()]
l = list(map(int, input().split()))
ans = 0
l.sort(reverse = True)
for i in l:
    if k % i == 0:
        print(k // i)
        break