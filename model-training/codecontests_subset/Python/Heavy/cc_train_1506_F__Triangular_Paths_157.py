
def get_input():
    l = [int(e) for e in input().split()]
    return l

def band(p):
    d = p[0] - p[1]
    return d//2

def cost_path(p1, p2):
    b1 = band(p2)
    b2 = band(p1)
    if b1>b2:
        return b1 - b2
    elif  p1[0] - p1[1] == p2[0] - p2[1]:
        if (p1[0] - p1[1]) % 2:
            return 0
        else:
            return p2[1] - p1[1]
    else:
        return 0
    

def main(n,r,c):
    # 1. sort the points
    ps = [(ri, ci) for ri, ci in zip(r,c)]
    ps.append((1,1))
    ps.sort()
    # 2. compute the path cost
    c = 0
    for i in range(n):
        # print(c, ps[i], ps[i+1], cost_path(ps[i], ps[i+1]))
        c += cost_path(ps[i], ps[i+1])
    print(c)


if __name__ == "__main__":
    t = get_input()[0]
    for _ in range(t):
        n = get_input()[0]
        r = get_input()
        c = get_input()
        main(n,r,c)