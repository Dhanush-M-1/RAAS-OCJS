class Tree:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def construct(l, dmap, curr_depth):
    if len(l) == 0:
        return None
    mx = max(l)
    dmap[mx] = curr_depth
    mx_idx = l.index(mx)
    root = Tree(mx)
    root.left = construct(l[:mx_idx], dmap, curr_depth + 1)
    root.right = construct(l[mx_idx + 1:], dmap, curr_depth + 1)
    return root

if __name__ == '__main__':
    t = int(input())

    for _ in range(t):
        n = int(input())
        l = list(int(num) for num in input().strip().split())[:n]
        dmap = dict()
        root = construct(l, dmap, 0)
        for item in l:
            print(dmap[item], end = " ")
        print()