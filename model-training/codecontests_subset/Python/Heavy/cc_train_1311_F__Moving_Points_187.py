def add(sms, cns, n, v, x):
    while v < n:
        sms[v] += x
        cns[v] += 1
        v += v & ~(v - 1)


def sumtoo(sms, cns, v):
    sm = 0
    cn = 0
    while v > 0:
        sm += sms[v]
        cn += cns[v]
        v -= v & ~(v - 1)
    return sm,cn

def go():
    n = int(input())
    x = list(map(int, input().split()))
    v = list(map(int, input().split()))

    sv = sorted(set(v))
    sv = {v: k for (k, v) in enumerate(sv,1)}
    v = [sv[v] for v in v]

    # mnv, mxv = min(v), max(v)
    # dfv = mxv - mnv
    a = sorted(((xx, vv) for xx, vv in zip(x, v)), reverse=True)

    len_sv = len(sv)+1
    sms = [0] * len_sv
    cns = [0] * len_sv

    res = 0
    sx = 0
    for cnt, (xx, vv) in enumerate(a):
        sm, cn = sumtoo(sms,cns,vv-1)
        # sm, cn = tree.sum_to(vv - mnv)
        sm, cn = sx - sm, cnt - cn
        res += sm - xx * cn
        add(sms, cns, len_sv, vv, xx)
        # tree.add(vv - mnv, xx)
        sx += xx

    return res


print(go())
