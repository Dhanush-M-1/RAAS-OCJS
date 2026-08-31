from collections import defaultdict
t = int(input())
for j in range(t):
    n,m = map(int, input().split())
    l1 = list(input())
    l_try = l1.copy()
    l_try.sort()
    l2 = list(map(int, input().split()))
    d = defaultdict(int)
    for i in l2:
        d[i] += 1
    sum = m
    All = [0]*26
    for i in range(len(l1)):
        count = sum
        if d.get(i+1):
            sum = sum - d.get(i+1)
        # print(count)
        All[ord(l1[i])-97] = All[ord(l1[i])-97] + count + 1
    print(*All)
