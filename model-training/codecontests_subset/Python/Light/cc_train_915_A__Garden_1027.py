n, k = map(int, input().split())
all = list(map(int, input().split()))
ma = -1
for i in range(len(all)):
    if k%all[i] == 0 and all[i] > ma:
        m = i
        ma = all[i]
print(k//all[m])