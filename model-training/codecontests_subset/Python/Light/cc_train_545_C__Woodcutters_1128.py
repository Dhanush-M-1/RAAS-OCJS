n = int(input())
PreN = -10**9
PreF = True
Cnt = 0

for i in range(n):
    CurN , CurH = map(int,input().split())
    if PreF == False and CurN - PreN > PreH:
        Cnt += 1
        PreN += PreH
    if CurN - PreN > CurH:
        Cnt += 1
        PreF = True
    else:
        PreF = False
    PreN, PreH = CurN, CurH

Cnt += (1-PreF)
print(Cnt)