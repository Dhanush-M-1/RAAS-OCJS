import copy, math, random, re, sys, time

def input_int(): return int(input())
def input_int_list(): return list(map(int, input().split()))
def input_str(): return input()
def input_str_list(): return input().split()


def min_cost(init, fin):
    if init == fin:
        return 0

    r1, c1 = init
    r2, c2 = fin

    even = (r1 + c1) % 2 == 0
    dr = r2 - r1
    dc = c2 - c1
    diag = dc
    vert = dr - dc

    #if (not even) or (even and dr > dc) => cost_diag = 0 
    cost_diag = 0
    if even and dr == dc:
        cost_diag = diag
    
    cost_vert = 0
    if even:
        cost_vert = math.floor(vert / 2)
    else:
        cost_vert = math.ceil(vert / 2)

    #! print(f"{init} -> {fin} : diag {cost_diag}  vert: {cost_vert}")

    return cost_diag + cost_vert



t = input_int()
for idx in range(1, t + 1):
    n = input_int()
    r = input_int_list()
    c = input_int_list()

    points = [(1, 1)] + [(r[i], c[i])for i in range(n)]
    points.sort(key=lambda x: x[0])

    cost = 0

    for i in range(len(points) - 1):
        cost += min_cost(points[i], points[i + 1])

    print(cost)
