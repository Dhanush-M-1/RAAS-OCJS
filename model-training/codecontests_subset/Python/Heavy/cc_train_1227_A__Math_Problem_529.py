from operator import itemgetter

test_count = int(input())
for _ in range(test_count):
    n = int(input())
    seg = list()
    for _ in range(n):
        a, b = map(int, input().split())
        seg.append((a, -1))
        seg.append((b, 1))
    seg.sort(key=itemgetter(0,1))
    left = -1
    right = -1
    for s in seg:
        if s[1] == 1:
            left = s[0]
            break
    for s in reversed(seg):
        if s[1] == -1:
            right = s[0]
            break

    print(max(right - left, 0))
