n = int(input())
line = list(map(int, input().split()))
m = int(input())
for _ in range(m):
    k, pos = map(int, input().split())
    lf = line[:]
    while len(lf) > k:
        j = -1
        x = min(lf)
        while j > -len(lf)-1:
            if lf[j] == x:
                del lf[j]
                if len(lf) == k:
                    break
            else:
                j -= 1
    print(lf[pos-1])
