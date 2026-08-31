def max_index(a, l, r):
    idx = l
    mx = a[l]
    for i in range(l, r+1):
        if a[i] > mx:
            idx = i
            mx = a[i]

    return idx

class Node:
    def __init__(self, data = None, left = None, right = None, depth = -1):
        self.left = left
        self.right = right
        self.data = data
        self.depth = depth

def create_perm_tree(a, l, r, d, node_map):
    if r-l < 0 or len(node_map) == len(a): return None
    
    mx_i = max_index(a, l, r)
    nd = Node()
    nd.data = a[mx_i]
    nd.depth = d
    create_perm_tree(a, l, mx_i-1, d+1, node_map)
    create_perm_tree(a, mx_i+1, r, d+1, node_map)

    node_map[mx_i] = nd.depth

t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))

    node_map = {}
    create_perm_tree(a, 0, n-1, 0, node_map)
    res = []
    for i in range(n):
        res.append(node_map[i])
    print(" ".join(str(r) for r in res))
    
    

