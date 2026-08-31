n = int(input())
prev, pres, ans = [], [], []
pres = list(map(int, input().split()))
prev = pres
for i in range(2):
    pres = list(map(int, input().split()))
    pres.sort()
    prev.sort()
    for j in range(len(pres)):
        if pres[j] != prev[j]:
            ans.append(prev[j])
            break
        if j == len(pres) - 1:
            ans.append(prev[j + 1])
    prev = pres
for i in ans:
    print(i)