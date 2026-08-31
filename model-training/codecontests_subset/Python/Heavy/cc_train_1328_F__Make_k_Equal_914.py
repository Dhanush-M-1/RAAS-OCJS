from sys import stdin

def input():
    return next(stdin)

def main():
    n,k = map(int,input().split())
    aa = [int(a) for a in input().split()]
    aa.sort()
    valmap = {}
    for a in aa:
        if add_to_map(a, 0, k, valmap):
            i = 0
            while a > 0:
                i+=1
                a = a//2
                if not add_to_map(a, i, k, valmap):
                    break

    result = min(s for c,s in valmap.values() if c == k)
    print(result)


def add_to_map(a, i, k, valmap):
    if a in valmap:
        if valmap[a][0] < k:
            valmap[a][0] += 1
            valmap[a][1] += i
            return True
        else:
            return False
    else:
        valmap[a] = [1, i]
        return True


if __name__ == "__main__":
    main()