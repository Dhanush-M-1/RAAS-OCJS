"""
NTC here
"""
import sys
# reader = (s.rstrip() for s in sys.stdin)
# input = reader.__next__
inp = sys.stdin.readline


def input(): return inp().strip()


out = []
# flush = sys.stdout.flush
# import threading
# sys.setrecursionlimit(10**7)
# threading.stack_size(2**25)


def iin(): return int(input())


def lin(): return list(map(int, input().split()))


# range = xrange
# input = raw_input


INF = 10**5+7
n = iin()
adj = [[] for i in range(n+1)]
for _ in range(n-1):
    i, j = lin()
    adj[i].append(j)
    adj[j].append(i)

# LCA - lowest common ancestor


def dfs(adj, start=1):
    n = len(adj)
    visited = [False]*n
    first = [-1]*n
    euler = []
    height = [-1]*n
    srt = [start]
    height[start] = 1
    parent = [-1]*n
    while srt:
        v = srt.pop()
        if visited[v]:
            euler.append(v)
            continue
        
        first[v] = len(euler)
        euler.append(v)
        visited[v] = True
        if parent[v] != -1:
            srt.append(parent[v])
        for u in adj[v]:
            if not visited[u]:
                parent[u] = v
                height[u] = height[v]+1
                srt.append(u)

    return first, euler, height


# segment tree
first, euler, height = dfs(adj)
# print(first, euler, height)
euler = [height[i] for i in euler]
__tree_length = len(euler)
segment_tree = [-1]*(__tree_length*4+1)
segment_tree_left = [-1]*(__tree_length*4+1)
segment_tree_right = [-1]*(__tree_length*4+1)

def set_segment_tree(x, val, l, r):
    #print('setting ', x, val, l, r)
    segment_tree[x] = val
    segment_tree_left[x] = l
    segment_tree_right[x] = r

def build(l=0, r=len(euler)-1, x=1):
    if l == r:
        set_segment_tree(x, euler[l], l, r)
    else:
        m = (l+r) >> 1
        left = build(l, m, (x << 1))
        right = build(m+1, r, (x << 1) | 1)
        val = min(left, right)
        set_segment_tree(x, val, l, r)
    return segment_tree[x]

def query(l, r, x=1):
    val, L, R = segment_tree[x], segment_tree_left[x], segment_tree_right[x]
    if l <= L and R <= r:
        return val
    elif r < L or l > R:
        return INF
    else:
        left = query(l, r, x << 1)
        right = query(l, r, x << 1 | 1)
        return min(left, right)
build()


def check(i, j):
    l, r = first[i], first[j]
    if l > r:
        l, r = r, l
    h = query(l, r)
    #print("CHK", l, r, h, i, j)
    return height[i] + height[j] - 2*h


# print(euler)
q = iin()
while q:
    q -= 1
    x, y, a, b, k = lin()
    ans1 = [check(a, b), check(a, x)+1+check(y, b),
            check(a, y)+1+check(x, b)]
    for i in ans1:
        if ((k-i) >= 0 and (k-i) % 2 == 0):
            out.append('YES')
            break
    else:
        out.append('NO')
    # print(ans, ans1)
    # out.append('YES' if True in ans else 'NO')
print('\n'.join(out))


# main()
# threading.Thread(target=main).start()
