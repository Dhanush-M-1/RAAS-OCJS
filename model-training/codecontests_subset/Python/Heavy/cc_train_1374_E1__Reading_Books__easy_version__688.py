import bisect
import sys
import math
input = sys.stdin.readline
import functools
import heapq

from collections import defaultdict

############ ---- Input Functions ---- ############

def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))

############ ---- Solution ---- ############

def solve():
    [n, m, k] = inlt()
    bks = []
    for i in range(n):
        [t, a, b] = inlt()
        bks.append((t, a, b, i+1))

    bks.sort(key=lambda x: x[0])

    aa_i = [v for v in bks if v[1] == 1 and v[2] == 0]
    bb_i = [v for v in bks if v[1] == 0 and v[2] == 1]
    cc_i = [v for v in bks if v[1] == 1 and v[2] == 1]
    dd_i = [v for v in bks if v[1] == 0 and v[2] == 0]

    aa = [0]
    bb = [0]
    cc = [0]
    dd = [0]

    for v in bks:
        if v[1] == 1 and v[2] == 0:
            aa.append(aa[-1] + v[0])
        if v[1] == 0 and v[2] == 1:
            bb.append(bb[-1] + v[0])
        if v[1] == 1 and v[2] == 1:
            cc.append(cc[-1] + v[0])
        if v[1] == 0 and v[2] == 0:
            dd.append(dd[-1] + v[0])

    take_a = min(len(aa)-1, k)
    take_b = min(len(bb)-1, k)
    take_c = 0
    take_d = 0

    while True:
        if take_c >= len(cc)-1:
            break
        picked = take_a + take_b + take_c + take_d
        if take_a + take_c < k or take_b + take_c < k:
            take_c += 1
        elif take_a > 0 and take_b > 0 and picked > m:
            take_c += 1
        elif take_a > 0 and take_b > 0 and (aa[take_a-1] + bb[take_b-1] + cc[take_c+1] < aa[take_a] + bb[take_b] + cc[take_c]):
            take_c += 1
        else:
            break
        while take_a + take_c > k and take_a > 0:
            take_a -= 1
        while take_b + take_c > k and take_b > 0:
            take_b -= 1
            
    if take_a + take_c < k or take_b + take_c < k or take_a + take_b + take_c + take_d > m:
        print(-1)
        return

    while take_a + take_b + take_c + take_d < m:
        cases = [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1], [1, 1, -1, 0]]
        cases = [[take_a + case[0], take_b + case[1], take_c + case[2], take_d + case[3]] for case in cases]
        flag = False
        for i, case in enumerate(cases):
            new_take_a = case[0]
            new_take_b = case[1]
            new_take_c = case[2]
            new_take_d = case[3]
            if new_take_a < 0 or new_take_a >= len(aa):
                continue
            if new_take_b < 0 or new_take_b >= len(bb):
                continue
            if new_take_c < 0 or new_take_c >= len(cc):
                continue
            if new_take_d < 0 or new_take_d >= len(dd):
                continue
            if not flag or aa[new_take_a] + bb[new_take_b] + cc[new_take_c] + dd[new_take_d] < aa[take_a] + bb[take_b] + cc[take_c] + dd[take_d]:
                take_a, take_b, take_c, take_d = new_take_a, new_take_b, new_take_c, new_take_d
                flag = True

    res = aa[take_a] + bb[take_b] + cc[take_c] + dd[take_d]
    res_arr = []
    for i in range(take_a):
        res_arr.append(aa_i[i][3])
    for i in range(take_b):
        res_arr.append(bb_i[i][3])
    for i in range(take_c):
        res_arr.append(cc_i[i][3])
    for i in range(take_d):
        res_arr.append(dd_i[i][3])

    res_arr.sort()
    res_arr = [str(v) for v in res_arr]
    
    print(res)
    print(" ".join(res_arr))
    
    return res
    

if len(sys.argv) > 1 and sys.argv[1].startswith("input"):
    f = open("./" + sys.argv[1], 'r')
    input = f.readline

res = solve()
