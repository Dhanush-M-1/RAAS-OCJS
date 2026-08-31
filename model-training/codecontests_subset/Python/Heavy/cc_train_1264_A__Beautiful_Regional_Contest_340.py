def find_medalist(c_ps_sorted, n):
    total = 0
    included = []
    while c_ps_sorted and total+c_ps_sorted[-1][1] <= n//2:
        total += c_ps_sorted[-1][1]
        included.append(c_ps_sorted.pop())
    included.reverse()
    return included


def medalist_numbers(included):
    try:
        gold = included.pop()
        silver = included.pop()

        while silver[1] <= gold[1]:
            new = included.pop()
            silver[0] = new[0]
            silver[1] = new[1] + silver[1]
    except IndexError:
        return 0, 0, 0

    if not included:
        return 0, 0, 0
    bronze = (min(e[0] for e in included), sum(e[1] for e in included))
    if bronze[1] <= gold[1]:
        return 0, 0, 0
    return gold[1], silver[1], bronze[1]

from collections import Counter
if __name__ == "__main__":
    t = int(input())
    for __ in range(t):
        n = int(input())
        ps = list(map(int, input().split()))
        c_ps = Counter(ps)
        c_ps_sorted = []
        for val, cnt in c_ps.items():
            c_ps_sorted.append([val, cnt])
        c_ps_sorted.sort()
        included = find_medalist(c_ps_sorted, n)
        print(*medalist_numbers(included))
