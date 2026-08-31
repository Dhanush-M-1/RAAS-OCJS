import sys

tc = int(sys.stdin.readline())
for _ in range(tc):
    l, r, d = map(int, sys.stdin.readline().split())
    left = (l // d) * d if l % d == 0 else ((l // d) + 1) * d
    right = (r // d) * d
    if d < l or d > r:
        print(d)
    else:
        temp = []
        if l <= left <= r and left - d > 0:
            temp.append(left - d)
        if l <= right <= r and right + d > 0:
            temp.append(right + d)
        if not temp:
            temp.append(d)
        temp.sort()
        print(temp[0])