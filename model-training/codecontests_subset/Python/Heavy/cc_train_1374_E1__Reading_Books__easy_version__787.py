N, K = [int(i) for i in input().split()]
T, A, B = [], [], []

Tall = []
Talice = []
Tbob = []

for i in range(N):
    t, a, b = [int(j) for j in input().split()]
    T.append(t)
    A.append(a)
    B.append(b)
    if a and b:
        Tall.append(t)
    elif a:
        Talice.append(t)
    elif b:
        Tbob.append(t)

Tall = sorted(Tall)
Talice = sorted(Talice)
Tbob = sorted(Tbob)

iall = 0
isep = 0
ans = 0
ml = min(len(Talice), len(Tbob))
for i in range(K):
    if iall >= len(Tall) and isep >= ml:
        ans = -1
        break
    if iall < len(Tall) and (isep >= ml or (Tall[iall] <= Talice[isep] + Tbob[isep])):
        ans += Tall[iall]
        iall += 1
    else:
        ans += Talice[isep] + Tbob[isep]
        isep += 1
print(ans)
