from copy import copy, deepcopy


def read_int():
    return int(input())


def read_arr():
    return [int(x) for x in input().split(' ')]


def read_mx(n):
    return [[int(num) for num in input().split(' ')] for _ in range(0, n)]


def work(p_case):
    n, k = read_arr()
    mx = read_mx(n)

    # split
    b_only = []
    a_only = []
    both = []
    for row in mx:
        cost = row[0]
        if row[1] and not row[2]:
            b_only.append(cost)
        elif row[2] and not row[1]:
            a_only.append(cost)
        elif row[1] and row[2]:
            both.append(cost)
    b_only.sort()
    a_only.sort()

    # merge
    ia, ib = 0, 0
    while ia < len(a_only) and ib < len(b_only):
        both.append(a_only[ia]+b_only[ib])
        ia += 1
        ib += 1

    both.sort()
    # print(both)
    sm, cnt = 0, 0
    while cnt < k and cnt < len(both):
        sm += both[cnt]
        cnt += 1

    if cnt == k:
        print(sm)
    else:
        print(-1)


if __name__ == "__main__":
    work(0)
    # t = read_int()     # cases
    # for case in range(0, t):
    #     work(case+1)
