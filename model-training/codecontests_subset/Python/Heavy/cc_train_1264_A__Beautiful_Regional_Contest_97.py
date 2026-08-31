n = int(input())
for _ in range(n):
    k = int(input())
    arr = list(map(int, input().split(' ')))

    same_num = []
    cnt = 0
    for i in range(k):
        if i == 0 or arr[i] == arr[i - 1]:
            cnt += 1
            if i == k - 1:
                same_num.append(cnt)
        else:
            same_num.append(cnt)
            cnt = 1

    g = same_num[0]
    #print(same_num)
    s, b = 0, 0
    pref_sum = 0
    for i in range(1, len(same_num)):
        pref_sum += same_num[i]
        if pref_sum > g and s == 0:
            s = pref_sum
            pref_sum = 0
        elif pref_sum > g and 2 * (g + s + pref_sum) <= k:
            b = pref_sum

    if b != 0:
        print(g, s, b)
    else:
        print("0 0 0")