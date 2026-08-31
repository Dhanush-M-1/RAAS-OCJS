n, k = map(int, input().split())
lForE = []
lForA = []
lForB = []
cnt = 0
forE = 0
forP = 0
ans = 0

for i in range(n):
    temp = list(map(int, input().split()))
    if temp[1] and temp[2]:
        lForE.append(temp[0])
    elif temp[1] and not temp[2]:
        lForA.append(temp[0])
    elif not temp[1] and temp[2]:
        lForB.append(temp[0])

lForE.sort()
lForA.sort()
lForB.sort()

while cnt < k and ((forP < len(lForB) and forP < len(lForA)) or forE < len(lForE)):
    cnt += 1
    if forP < len(lForB) and forP < len(lForA) and forE < len(lForE):
        if lForA[forP] + lForB[forP] < lForE[forE]:
            ans += lForA[forP] + lForB[forP]
            forP += 1
        else:
            ans += lForE[forE]
            forE += 1
    elif forE < len(lForE):

        ans += lForE[forE]
        forE += 1
    elif forP < len(lForB) and forP < len(lForA):
        ans += lForA[forP] + lForB[forP]
        forP += 1

if cnt < k:
    print(-1)
else:
    print(ans)
