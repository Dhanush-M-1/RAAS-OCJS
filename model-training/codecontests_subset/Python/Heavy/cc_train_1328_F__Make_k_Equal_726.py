from sys import stdin

def input():
    return next(stdin)

def main():
    n,k = map(int,input().split())
    aa = [int(a) for a in input().split()]
    aa.sort()
    valmap = {}
    for a in aa:
        add_to_map(a, 0, k, valmap)
        i = 0
        while a > 0:
            i+=1
            a = a//2
            add_to_map(a, i, k, valmap)

    min = 20*k
    for vl in valmap.values():
        if len(vl) == k and sum(vl) < min:
            min = sum(vl)
    print(min)


def add_to_map(a, i, k, valmap):
    if a in valmap:
        if len(valmap[a]) < k:
            valmap[a].append(i)
    else:
        valmap[a] = [i]


if __name__ == "__main__":
    main()