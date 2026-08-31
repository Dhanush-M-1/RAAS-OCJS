#----------------------------------------------------
#   = = >  CCCCooodddeeefffooorrrccceeesss  < = =
#----------------------------------------------------
n = int(input())
L = []
for i in range(n):
    L.append(input().split())

def Rec(s):
    if s == n-1:
        return 0
    else:
        a, b = L[s]
        ilova = 0
        for i in range(s+1, n):
            if L[i][0] == b:
                ilova += 1
            if L[i][1] == a:
                ilova += 1
        return ilova + Rec(s + 1)

print(Rec(0))