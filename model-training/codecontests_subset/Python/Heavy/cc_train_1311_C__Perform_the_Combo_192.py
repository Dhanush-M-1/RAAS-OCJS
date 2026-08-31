caseNum = int(input())

def arrayAdd(a,b):
    for i in range(len(a)):
        a[i] = a[i] + b[i]
    return a

for i in range(caseNum):
    n,m = map(int,input().split())
    combo = input()
    p = list(map(int,input().split(' ')))

    ans = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    posValueBase = ans
    posValue = []*len(combo)
    cnt = 0

    for char in combo:
        posValueBase[ord(char)-ord('a')] = posValueBase[ord(char)-ord('a')]+1
        posValue.append(posValueBase.copy())

    for pi in p:
        ans = arrayAdd(ans,posValue[pi-1])

    for ansi in ans:
        print(ansi,end=' ')
    print()