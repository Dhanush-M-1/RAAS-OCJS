def get_occurences(lst):
    occl = []

    for i, elem in enumerate(lst):
        if not i:
            occl.append(1)
        else:
            if elem == lst[i - 1]:
                occl[len(occl) - 1] += 1
            else:
                occl.append(1)

    return occl


def get_max_winners(occ_lst):
    n = sum(occ_lst)
    mx_w = n // 2
    cnt = 0
    idx = -1

    for i, occ in enumerate(occ_lst):
        if cnt + occ > mx_w:
            idx = i
            break
        else:
            cnt += occ

    return occ_lst[:idx]


def get_prizes(winners):
    if len(winners) < 3:
        return 0, 0, 0
    gold = winners[0]

    silver = 0
    s_idx = -1

    for i, occ in enumerate(winners):
        if i:
            if silver > gold:
                s_idx = i
                break
            else:
                silver += occ

    bronze = 0 if s_idx == -1 else sum(winners[s_idx:])

    if (not silver > gold) or (not bronze > gold):
        return 0, 0, 0
    return gold, silver, bronze


if __name__ == '__main__':
    for _ in range(int(input())):
        input()
        print(*get_prizes(get_max_winners(get_occurences(list(map(int, input().split()))))))
