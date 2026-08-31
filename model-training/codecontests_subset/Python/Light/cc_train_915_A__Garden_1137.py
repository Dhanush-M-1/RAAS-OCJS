n, k = list(map(int, input().split()))
a = sorted(list(map(int, input().split())))[::-1]
for b in a:
    if k % b == 0:
        print(k//b)
        break

