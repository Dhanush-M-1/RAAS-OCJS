def solve():
    res = []
    s = input()
    lines_in_file, n, m = [int(e) for e in input().split()]
    f, sec = 0, 0
    first = [int(e) for e in input().split()]
    second = [int(e) for e in input().split()]
    for i in range(n + m):
        if f < n and first[f] == 0:
            lines_in_file += 1
            res.append(first[f])
            f += 1
        elif sec < m and second[sec] == 0:
            lines_in_file += 1
            res.append(second[sec])
            sec += 1
        elif f < n and first[f] > 0 and first[f] <= lines_in_file:
            res.append(first[f])
            f += 1
        elif sec < m and second[sec] > 0 and second[sec] <= lines_in_file:
            res.append(second[sec])
            sec += 1
        else:
            return [-1]
    return res


cases = int(input())
while cases > 0:
    cases -= 1
    print(*solve())