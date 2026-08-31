# Wrong answer on test 7

n, k = map(int, input().split())
ar = [int(p) for p in input().split()]

ar.sort()
for i in range(n-1, -1, -1):
    if not (k % ar[i]):
        print(k//ar[i])
        break
