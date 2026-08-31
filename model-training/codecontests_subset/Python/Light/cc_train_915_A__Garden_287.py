n, k = map(int, input().split())

for i in sorted(map(int, input().split()), reverse=True):
    if k % i == 0:
        print(k // i)
        break
