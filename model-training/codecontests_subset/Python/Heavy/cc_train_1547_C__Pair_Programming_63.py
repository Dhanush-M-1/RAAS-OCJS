for _ in range(int(input())):
    input()
    code = [0 for _ in range(301)]
    k, _, _ = [int(i) for i in input().split()]
    mono = [int(i) for i in input().split()]
    poly = [int(i) for i in input().split()]
    ret = []
    m, p = 0, 0
    while len(ret) != len(mono) + len(poly):
        if p < len(poly):
            pp = poly[p]
        else:
            pp = -999
        if m < len(mono):
            mm = mono[m]
        else:
            mm = -999
        if mm == 0:
            m += 1
            k += 1
            ret.append('0')
        elif pp == 0:
            p += 1
            k += 1
            ret.append('0')
        elif mm > 0 and  mm <= k:
            code[mm] = 1
            m += 1
            ret.append(str(mm))
        elif pp > 0 and pp <= k:
            code[pp] = 1
            p += 1
            ret.append(str(pp))
        else:
            print('-1')
            break
    else:
        print(' '.join(ret))
