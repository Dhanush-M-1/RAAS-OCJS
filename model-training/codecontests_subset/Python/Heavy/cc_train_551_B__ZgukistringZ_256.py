def get_profile(s):
    p = [0] * 26
    for c in s:
        p[ord(c) - ord('a')] += 1
    return p

def get_ans_one_str(a, b):
    return min(has // need for (has, need) in zip(a, b) if need > 0)

def get_ans_two_strs(a, b, c):
    left = list(a)
    b_count = 0
    res = None
    while True:
        c_count = get_ans_one_str(left, c)
        cur_res = (b_count + c_count, b_count, c_count)
        #print c_count, b_count
        if res is None or cur_res > res:
            res = cur_res

        for i, b_x in enumerate(b):
            left[i] -= b_x
        
        if min(left) < 0:
            break

        b_count += 1

    return res

    
def solve(a_s, b_s, c_s):
    a, b, c = map(get_profile, (a_s, b_s, c_s))
    ans, b_cnt, c_cnt = get_ans_two_strs(a, b, c)
    for i, b_x in enumerate(b):
        a[i] -= b_x * b_cnt

    for i, c_x in enumerate(c):
        a[i] -= c_x * c_cnt

    #print c_cnt, b_cnt
    return ''.join([b_s] * b_cnt + [c_s] * c_cnt + [chr(ord('a') + i) * c for (i, c) in enumerate(a)])

print(solve(*[input().strip() for i in range(3)]))
        
