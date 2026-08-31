from pprint import pprint
from copy import deepcopy
q = int(input())
for _ in range(q):
    n, m = map(int, input().split())
    s = input()
    datp = list(map(int, input().split()))
    kmap = [0] * 26
    totalkey = []
    for i in range(n):
        # a=0, b=1
        c = ord(s[i]) - ord('a')
        kmap[c] += 1
        totalkey.append(deepcopy(kmap))
    #pprint(totalkey)
    res = [0] * 26
    for i in range(m):
        #print("i", i)
        for k in range(26):
            res[k] += totalkey[datp[i] - 1][k]
    for k in range(26):
        res[k] += totalkey[-1][k]
    #print("res")
    #print(res)
    print(" ".join(list(map(str, res))))
