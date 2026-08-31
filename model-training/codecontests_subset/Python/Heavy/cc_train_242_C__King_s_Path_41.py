def check_path(xs, ys, xe, ye, dct, visited):
    xchange = [1, -1, 1, -1, 1, -1, 0, 0]
    ychange = [1, -1, -1, 1, 0, 0, 1, -1]
    i = 0
    if ye == ys and xe == xs:
        return 0
    node = [ys, xs, 0]
    visited.append(node)
    while len(visited):
        xs = visited[0][1]
        ys = visited[0][0]
        steps =  visited[0][2] + 1 
        for m in range(8): # 8
            mx = xs + xchange[m]
            my = ys + ychange[m]
            node = [my, mx, steps]
            if my == ye and mx == xe:
                return steps
            if (my, mx) in dct:# len of dct
                visited.append(node)
                del dct[(my, mx)]

        visited.pop(0)
        i += 1
    return -1


dct = {}
visited = []
y1, x1, y2, x2 =[int(i) for i in input().split()]
n = int(input())
for _ in range(n):
    r, a, b =[int(i) for i in input().split()]
    for i in range(a, b + 1):
        s = str([r, i])
        dct[(r, i)] = 1
print(check_path(x1, y1, x2, y2, dct, visited))