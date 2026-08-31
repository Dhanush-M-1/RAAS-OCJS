def actions():
    space = input()
    k, n, m = map(int, input().split())
    monocarp = list(map(int, input().split()))
    polycarp = list(map(int, input().split()))
    pages = set(range(1, k + 1))
    if len(pages) == 0:
        pages.add(0)
    sequence = []
    while len(polycarp) > 0 or len(monocarp) > 0:
        if len(polycarp) > 0 and polycarp[0] == 0:
            pages.add(max(pages) + 1)
            sequence.append(polycarp.pop(0))
            continue
        elif len(monocarp) > 0 and monocarp[0] == 0:
            pages.add(max(pages) + 1)
            sequence.append(monocarp.pop(0))
            continue
        elif len(polycarp) > 0 and polycarp[0] in pages:
            sequence.append(polycarp.pop(0))
            continue
        elif len(monocarp) > 0 and monocarp[0] in pages:
            sequence.append(monocarp.pop(0))
            continue
        return ["-1"]
    sequence = list(map(str, sequence))
    return sequence


ans = []
t = int(input())
for i in range(t):
    ans.append(actions())
for i in ans:
    print(" ".join(i))