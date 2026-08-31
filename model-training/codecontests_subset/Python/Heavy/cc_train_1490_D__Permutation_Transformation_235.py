def dfs(permutation):
    global newDict, counter
    maxa = max(permutation)
    if len(permutation) == 1:
        newDict.update({maxa: counter})
        return
    else:
        pos = permutation.index(maxa)
        dfs([maxa])
        counter += 1
        if pos != 0:
            dfs(permutation[:pos])
        if pos + 1 < len(permutation):
            dfs(permutation[pos + 1:])
        counter -= 1


t = int(input())
for i in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    counter = 0
    newDict = {}
    dfs(arr)
    for j in arr:
        print(newDict[j], end=' ')