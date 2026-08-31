def k_equal(l, k):
    d = {}
    total = 0
    for i in l:
        total += i
        if i not in d:
            d[i] = 1
        else:
            d[i] += 1
    len_l = len(l)
    l = sorted(d.keys())
    #print(l, "l")
    smallest_k = l[0]
    len_d = len(d)
    both_D = len_l - k  # n - k
    accumulating_total = accumulating_amt = 0
    resu = None
    #for C in range(l[0], l[-1] + 1):
    for C in l: # err...
        res = None
        right_total = total - accumulating_total
        #print(len_l, accumulating_amt)
        amt_right_and_center = len_l - accumulating_amt
        right_S = right_total - C * amt_right_and_center
        right_D = amt_right_and_center - k
        #print(amt_right_and_center, k)

        left_S = accumulating_amt * C - accumulating_total
        if C in d:
            if d[C] >= k:
                return 0
            accumulating_total += C * d[C]
            accumulating_amt += d[C]
        left_D = accumulating_amt - k

        right_f = left_f = None

        #print(right_S, right_D)

        if right_D >= 0:
            right_f = right_S - right_D
            if right_f < 0:
                right_f = 0
        if left_D >= 0:
            left_f = left_S - left_D
            if left_f < 0:
                left_f = 0
        if right_f == left_f:
            if right_f == None:
                both_S = left_S + right_S
                both_f = both_S - both_D
                res = both_f
            else:
                res = right_f
        else:
            if right_f == None:
                res = left_f
            elif left_f == None:
                res = right_f
            else:
                res = min(left_f, right_f)
        #print(left_f, right_f)

        if resu == None:
            resu = res
        else:
            resu = min(resu, res)
    return resu



'''
l = [1, 2, 2, 4, 2, 3]
k = 5
print(k_equal(l, k))
l2 = [3, 3, 2, 1, 1, 1, 3]
k2 = 5
print(k_equal(l2, k2))
'''
n, k = list(map(int, input().split(" ")))
l = list(map(int, input().split(" ")))
print(k_equal(l, k))