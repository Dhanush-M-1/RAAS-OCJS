#tamat0's submission
def main():
    import sys
    input = sys.stdin.buffer.readline
 
    class SegTree():
        def __init__(self, N):
            # N:  処理する区間の長さ
            self.N0 = 2 ** (N - 1).bit_length()
            self.INF = 2 ** 31 - 1
            self.seg_min = [self.INF] * (2 * self.N0)
 
        def update(self, index, value):
            index += self.N0 - 1
            self.seg_min[index] = value
            while index > 0:
                index = (index - 1) // 2
                self.seg_min[index] = min(self.seg_min[index * 2 + 1], self.seg_min[index * 2 + 2])
 
        def query(self, first, last):
            first += self.N0 - 1
            last += self.N0 - 1
            ret = self.INF
            while first <= last:
                if not first & 1:
                    ret = min(ret, self.seg_min[first])
                if last & 1:
                    ret = min(ret, self.seg_min[last])
                first = first // 2
                last = last // 2 - 1
            return ret
 
    # adj[0] must be empty list
    def EulerTour(adj, root):
        st = [root]
        ret = []
        seen = [0] * len(adj)
        par = [0] * len(adj)
        depth = [0] * len(adj)
        while st:
            v = st.pop()
            if seen[v]:
                ret.append(v)
                continue
            ret.append(v)
            seen[v] = 1
            if par[v] != 0:
                st.append(par[v])
            for u in adj[v]:
                if seen[u] == 0:
                    st.append(u)
                    par[u] = v
                    depth[u] = depth[v] + 1
 
        return ret, depth
 
    N = int(input())
    adj = [[] for _ in range(N+1)]
    for _ in range(N-1):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)
 
    et, depth = EulerTour(adj, 1)
    segtree = SegTree(len(et) + 1)
    left = [-1] * (N + 1)
    right = [-1] * (N + 1)
    for i, v in enumerate(et):
        segtree.update(i + 1, depth[v])
        if left[v] < 0:
            left[v] = i
        right[v] = i
 
    q = int(input())
    for i in range(q):
        x, y, a, b, k = map(int, input().split())
        lca_depth_AB = segtree.query(min(left[a], left[b]) + 1, max(right[a], right[b]) + 1)
        AB = depth[a] + depth[b] - 2 * lca_depth_AB
        if k >= AB and (k-AB)%2 == 0:
            print('YES')
            continue
        lca_depth_AX = segtree.query(min(left[a], left[x]) + 1, max(right[a], right[x]) + 1)
        AX = depth[a] + depth[x] - 2 * lca_depth_AX
        lca_depth_BY = segtree.query(min(left[b], left[y]) + 1, max(right[b], right[y]) + 1)
        BY = depth[b] + depth[y] - 2 * lca_depth_BY
        AB_new = AX + BY + 1
        if k >= AB_new and (k-AB_new)%2 == 0:
            print('YES')
            continue
        lca_depth_AY = segtree.query(min(left[a], left[y]) + 1, max(right[a], right[y]) + 1)
        AY = depth[a] + depth[y] - 2 * lca_depth_AY
        lca_depth_BX = segtree.query(min(left[b], left[x]) + 1, max(right[b], right[x]) + 1)
        BX = depth[b] + depth[x] - 2 * lca_depth_BX
        AB_new = AY + BX + 1
        if k >= AB_new and (k-AB_new)%2 == 0:
            print('YES')
            continue
        print('NO')
 
 
if __name__ == '__main__':
    main()