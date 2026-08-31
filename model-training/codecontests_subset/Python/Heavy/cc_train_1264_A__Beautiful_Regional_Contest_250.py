t = int(input())
def calcMedals(l):
    half = len(l)//2
    g = 0
    s = 0
    b = 0
    goldDone = False
    silDone = False
    silCutoff = -1
    for i in range(half):
        if goldDone == False:
            g += 1
        elif silDone == False:
            s += 1
        if l[i+1] != l[i] and goldDone == False:
            goldDone = True
        elif l[i+1] != l[i] and silDone == False and s > g:
            silDone = True
            silCutoff = i
            break
    if silDone == False:
        return [0,0,0]
    else:
        for i in range(half-1,silCutoff,-1):
            if l[i] != l[i+1]:
                b = i-silCutoff
                break
        if b > g:
            return [g,s,b]
        else:
            return [0,0,0]
        
for i in range(t):
    n = int(input())
    l = list(map(int, input().strip().split()))
    medals = calcMedals(l)
    print(medals[0], medals[1], medals[2])