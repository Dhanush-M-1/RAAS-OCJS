def num_path2(list_pairs):
    cnt = 0
    l, r = 1, 1

    ind = 0
    while True:
        # print(l, r, ind)
        if ind == len(list_pairs): break

        l_targ, r_targ = list_pairs[ind]
        if (l, r) == (l_targ, r_targ):
            ind += 1
        elif r_targ == r:
            cum = (l_targ - l) // 2
            if (l_targ - l) % 2 == 1:
                if (r + l) % 2 == 1: cum += 1
            cnt += cum
            l, r = l_targ, r_targ
            ind += 1
        elif l_targ - l == r_targ - r:
            if (r + l) % 2 == 0: cnt += l_targ - l
            l, r = l_targ, r_targ
            ind += 1
        else:
            r_cand = r if (l + r) % 2 == 0 else r + 1

            if 0 <= r_targ - r_cand <= l_targ - l - 1:
                r = r_cand
            else:
                cnt += 1
                r = r + 1 if (l + r) % 2 == 0 else r
            l += 1
        print(l, r, cnt)

    return cnt



def num_path(list_pairs):

    cnt = 0
    l, r = 1, 1

    ind = 0
    while True:
        if ind == len(list_pairs): break

        l_targ, r_targ = list_pairs[ind]
        if (l, r) == (l_targ, r_targ):
            ind += 1
        elif r_targ == r:
            cum = (l_targ - l) // 2
            if (l_targ - l) % 2 == 1:
                if (r+l) % 2 == 1: cum += 1
            cnt += cum
            l, r = l_targ, r_targ
            ind += 1
        elif l_targ - l == r_targ - r:
            if (r+l) % 2 == 0: cnt += l_targ - l
            l, r = l_targ, r_targ
            ind += 1
        else:
            if (r+l) % 2 == 1:
                jump = r_targ-r
                l, r = l + jump, r + jump
            else:
                l, r = l + 1, r
        #print(l, r , cnt)
    return cnt


if __name__ == "__main__":
    num = int(input())
    for i in range(num):
        input()
        list_r = [int(el) for el in input().split()]
        list_c = [int(el) for el in input().split()]
        list_pairs = [(r, c) for r, c in zip(list_r, list_c)]
        list_pairs.sort()
        print(num_path(list_pairs))
        #print(num_path2(list_pairs))