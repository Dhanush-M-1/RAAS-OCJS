def buildTree(array, lvl):
    if(len(array) == 1):
        return str(lvl)
    elif(len(array) == 0):
        return ""

    depths = str(lvl)
    maxi = 0
    max = 0
    for i in range(len(array)):
        if(array[i] > max):
            max = array[i]
            maxi = i
    
    lvl += 1
    depths = " "*(array[:maxi] != []) + depths + " "*(array[maxi + 1:] != [])
    depths = buildTree(array[:maxi], lvl) + depths + buildTree(array[maxi + 1:], lvl)
    return depths

t = int(input())

out = []
for i in range(t):
    n = input()
    s = list(map(int, input().split()))
    out.append(buildTree(s, 0))

for j in out:
    print(j)