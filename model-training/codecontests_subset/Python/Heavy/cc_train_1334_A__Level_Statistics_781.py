def level_stat(n):
    xyz = input

    p = [0]*n
    c = [0]*n
    for i in range(n):
        tmp = [int(x) for x in xyz().split()]
        p[i] = tmp[0]
        c[i] = tmp[1]

    if p != sorted(p) or c != sorted(c):
        return 'NO'

    for i in range(n):
        if c[i] > p[i]:
            return 'NO'
        elif c[i] == p[i]:
            if i != 0:
                if p[i] - p[i-1] != c[i] - c[i-1]:
                    return "NO"
        else:
            if i != 0:
                if p[i] - p[i-1] < c[i] - c[i-1]:
                    return 'NO'
    return 'YES'
    

if __name__=="__main__":
    xyz = input
    t = int(xyz())

    for i1 in [0]*t:
        n = int(xyz())
        print(level_stat(n))