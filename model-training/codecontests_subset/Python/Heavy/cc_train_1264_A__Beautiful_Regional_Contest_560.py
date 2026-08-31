t = int(input())
for tt in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    # print('a',a)
    if n < 10:
        print('0 0 0')
        continue

    cur = a[0]
    cnt = 1
    cnt_list = []
    for i in range(1,n):
        if cur == a[i]:
            cnt += 1
        else:
            cur = a[i]
            cnt_list.append(cnt)
            cnt = 1
    cnt_list.append(cnt)
    # print('cnt_list', cnt_list)
    k = len(cnt_list)
    qsum = [None] * k
    g = cnt_list[0]
    sum_g = g
    sum_s = None
    sum_b = None
    for i in range(k):
        if i == 0:
            qsum[i] = cnt_list[i]
        else:
            qsum[i] = cnt_list[i] + qsum[i-1]

    for i in range(k):
        if qsum[i] > 2 * sum_g:
            # s > g
            sum_s = qsum[i] - sum_g
            break
    if sum_s is None:
        print('0 0 0')
        continue

    b_ind = None
    for i in range(k-1, -1, -1):
        if 2*qsum[i] <= n:
            b_ind = i
            break

    if b_ind is None:
        print('0 0 0')
        continue

    sum_b = qsum[b_ind] - sum_g - sum_s
    if sum_b <= sum_g:
        print('0 0 0')
        continue

    if 2 * (sum_g + sum_b + sum_s) <= n:
        print(sum_g, sum_s, sum_b)
        continue
    else:
        print('0 0 0')
        continue
