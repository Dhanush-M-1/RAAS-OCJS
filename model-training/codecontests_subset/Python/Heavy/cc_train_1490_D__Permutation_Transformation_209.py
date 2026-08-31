testcases = int(input())
import sys
def get_ints(): return list(map(int, sys.stdin.readline().strip().split()))

dicts = {}
    
def dfs(newarr, lvl):
    global dicts
    newarrlen = len(newarr)
    if newarrlen == 0 :
        return 
    maxs = max(newarr)
    #print(newarr)
    maxsindex = newarr.index(maxs)
    if newarrlen == 1:
        dicts[maxs] = lvl + 1 
        return 
    dicts[maxs] = lvl + 1     
    dfs(newarr[:maxsindex], lvl + 1)
    dfs(newarr[maxsindex + 1:], lvl + 1 )

for testcase in range(testcases):
    n = int(input())
    arr = get_ints()
    maxs = max(arr)
    maxsindex = arr.index(maxs)
    dicts[maxs] = 0 
    newlef = arr[:maxsindex]
    #print(newlef)
    newright = arr[maxsindex + 1:]
    #print(newright)
    dfs(arr[:maxsindex], 0)
    dfs(arr[maxsindex + 1:], 0)
    
    #print(dicts)
    ans = []
    for i in arr:
        if i in dicts:
            ans.append(str(dicts[i]))
    print(" ".join(ans))
    
    
    