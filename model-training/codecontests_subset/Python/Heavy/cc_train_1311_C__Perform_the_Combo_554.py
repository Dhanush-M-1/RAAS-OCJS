from collections import Counter
for _ in range(0,int(input())):
    n, m = map(int, input().split())
    L = input()
    arr = list(map(int, input().split()))
    arr.sort()
    Seq = list(map(chr, range(ord('a'), ord('z') + 1)))
    Dict = {}
    Dict = Dict.fromkeys(Seq,0)
    k = 0
    for j in L:
        Dict[j] = Dict[j] + 1
    for i in range(0,m):
        for j in range(k,arr[i]):
            Dict[L[j]] = Dict[L[j]] + m - i
        k = arr[i]
    res = Dict.values()
    for i in res:
        print(i,end=' ')
    print()