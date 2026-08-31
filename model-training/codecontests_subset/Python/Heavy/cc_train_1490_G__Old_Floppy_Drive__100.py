from math import ceil
from bisect import bisect_left

def find():
    n, m = map(int, input().split())
    sum_a = 0
    pref = {}
    pref_s = [0]
    ind = 0
    for j in input().split():
        sum_a += int(j)
        if sum_a not in pref:
            pref[sum_a] = ind
        if sum_a > pref_s[-1]:
            pref_s.append(sum_a)
        ind += 1

    for j in input().split():
        j = int(j)
        ans = 0
        if j <= pref_s[-1]:
            my_pref = j
        else:
            if sum_a <= 0:
                print(-1, end=' ')
                continue
            else:
                tmp = ceil((j - pref_s[-1]) / sum_a)
                my_pref = max(0, j - tmp * sum_a)
                ans += tmp * n

        print(ans + pref[pref_s[bisect_left(pref_s, my_pref,  lo=1)]], end=' ')
    print()


for i in range(int(input())):
    find()