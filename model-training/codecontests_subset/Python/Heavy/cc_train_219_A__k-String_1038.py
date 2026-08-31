def printer(strq, k):
    new_lst = list(set(strq))
    new_lst = sorted(new_lst)
    for i in range(len(new_lst)):
        if strq.count(new_lst[i]) % k:
            return -1
    return new_lst


k, s = int(input()), list(input())
if len(s) % k:
    print(-1)
else:
    s_new = printer(s, k)
    if s_new == -1:
        print(-1)
    else:
        d = {a: s.count(a) for a in s_new}
        last_s = ''
        for i in s_new:
            if s.count(i) // k == 0:
                last_s += i
            else:
                last_s += i * (s.count(i) // k)
        print(last_s * k)

