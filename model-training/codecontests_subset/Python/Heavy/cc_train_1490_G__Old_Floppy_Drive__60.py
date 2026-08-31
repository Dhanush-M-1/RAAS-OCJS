from math import ceil

def find():
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    x = list(map(int, input().split()))
    sum_a = 0
    pref = {}
    pref_s = [0]
    for j in range(n):
        sum_a += a[j]
        if sum_a not in pref:
            pref[sum_a] = j
        if a[j] > 0 and sum_a > pref_s[-1]:
            pref_s.append(sum_a)

    for j in x:
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

        ind_min = 1
        ind_max = len(pref_s) - 1
        while ind_min != ind_max:
            ind_new = (ind_min + ind_max) // 2
            if pref_s[ind_new] < my_pref:
                ind_min = ind_new + 1
            else:
                ind_max = ind_new

        print(ans + pref[pref_s[ind_max]], end=' ')
    print()


for i in range(int(input())):
    find()