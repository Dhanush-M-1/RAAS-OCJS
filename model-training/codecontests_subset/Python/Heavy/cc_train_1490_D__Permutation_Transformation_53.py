def found_depth_tree(start, end, depth, ls, cnt):
    # print(start, ' ',end, ' ',depth)
    if start > end:
        return

    if start == end:
        depth[start] = cnt

    max_ind = start

    for i in range(start+1, end+1):
        if ls[max_ind] < ls[i]:
            max_ind = i

    depth[max_ind] = cnt

    found_depth_tree(start, max_ind-1, depth, ls, cnt + 1)
    found_depth_tree(max_ind+1, end, depth, ls, cnt + 1)
    return 

t = int(input())

for _ in range(t):

    n = int(input())
    ls = [int(i) for i in input().split()]
    depth = [-1 for i in range(n)]

    found_depth_tree(0, n-1, depth, ls, 0)

    print(*depth)

