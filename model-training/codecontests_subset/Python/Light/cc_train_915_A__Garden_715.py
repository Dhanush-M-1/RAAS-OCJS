n, k = map(int, input().split())
A = list(map(int, input().split()))
A.sort(reverse=True)
for i in A:
    if k % i == 0:
        print(k // i)
        break
