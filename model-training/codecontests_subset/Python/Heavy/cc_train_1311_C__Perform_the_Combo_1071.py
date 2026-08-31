import string
#codeforces 2 8 3 2 9
for _ in [0]*int(input()):
    n,m = map(int, input().split())
    s = list(input())
    t = sorted(list(map(int, input().split())))
    ind = len(t)
    k = 0
    c = 0
    ret = dict()
    for i in string.ascii_lowercase:
        ret[i] = 0
    for i in t:
        if k == 0 or t[k] != t[k - 1]:
            for l in range(c,i):
                ret[s[l]] += ind
                c = i
        k += 1
        ind -=1
    else:
        for i in s:
            ret[i] += 1
    for q in ret.values():
        print(q,end =' ')
    print()
