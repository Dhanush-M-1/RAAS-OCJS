class Node(object):
    def __init__(self, val):
        self.left = None
        self.right = None
        self.val = val
def perm_to_tree(d, level, node, a):
    if a==[]:
        return 
    idx = a.index(max(a))
    d[a[idx]] = level
    node = Node(a[idx])
    perm_to_tree(d, level+1, node.left, a[:idx])
    perm_to_tree(d, level+1, node.right, a[idx+1:])
    
    
    
    
for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    root = None
    d = {}
    perm_to_tree(d,0, root,a)
    ans = [0]*n
    for i in range(n):
        ans[i] = d[a[i]]
    print(*ans)
        