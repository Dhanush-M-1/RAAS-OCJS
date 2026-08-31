n = int(input())
L = list(map(int, input().split()))
cnt = 0
for i in range(len(L)-1):
    x = L[i+1:].index(min(L[i+1:])) + i + 1
    if L[i] > L[x]:
        L[i], L[x] = L[x], L[i]
        cnt += 1
print(' '.join(str(x) for x in L))
print(cnt)
