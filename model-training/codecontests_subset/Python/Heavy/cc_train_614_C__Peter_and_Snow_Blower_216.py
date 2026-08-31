from math import pi


def vadd(v1, v2):
    return v1[0]+v2[0], v1[1]+v2[1]

def vsub(v1, v2):
    return v1[0]-v2[0], v1[1]-v2[1]

def smul(s, v):
    return s*v[0], s*v[1]

def dot(v1, v2):
    return v1[0]*v2[0] + v1[1]*v2[1]

def vmag2(v):
    return v[0]*v[0] + v[1]*v[1]


def segment_dist2(p, v, w):
    vp = vsub(p, v)
    vw = vsub(w, v)
    l2 = vmag2(vw)
    t = dot(vp, vw) / float(l2)

    if t <= 0:
        proj = v
    elif t >= 1:
        proj = w
    else:
        proj = vadd(v, smul(t, vw))

    return vmag2(vsub(p, proj))


def area(p, q):
    r2min, r2max = None, None
    qprev = q[-1]
    for qi in q:
        r2 = vmag2(vsub(p, qi))
        sd2 = segment_dist2(p, qi, qprev)
        if r2max is None or r2 > r2max:
            r2max = r2
        if r2min is None or sd2 < r2min:
            r2min = sd2
        qprev = qi

    return pi * (r2max-r2min)


if __name__ == '__main__':
    n, px, py = map(int, input().split())
    q = [tuple(map(int, input().split())) for _ in range(n)]
    print(area((px, py), q))
