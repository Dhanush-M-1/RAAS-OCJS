#include <bits/stdc++.h>
using namespace ::std;
const int N = 1000;
struct union_find_tree {
  vector<int> parent;
  vector<int> height;
  vector<int> group_size;
  vector<bool> diff;
  void init1(int uf_n) {
    parent.resize(uf_n);
    height.resize(uf_n);
    group_size.resize(uf_n);
    diff.resize(uf_n);
  }
  void init(int uf_n) {
    for (int i = 0; i < uf_n; i++) {
      parent[i] = i;
      height[i] = 0;
      group_size[i] = 0;
      diff[i] = false;
    }
  }
  pair<int, bool> get_root(int now) {
    if (parent[now] == now) return pair<int, bool>(parent[now], diff[now]);
    pair<int, bool> op = get_root(parent[now]);
    diff[now] = diff[now] ^ diff[parent[now]];
    parent[now] = parent[parent[now]];
    return pair<int, bool>(parent[now], diff[now]);
  }
  void merge(int v1, int v2) {
    pair<int, bool> p1 = get_root(v1), p2 = get_root(v2);
    v1 = p1.first, v2 = p2.first;
    bool di = p1.second ^ p2.second;
    if (height[v1] < height[v2]) swap(v1, v2);
    parent[v2] = v1;
    group_size[v1] += group_size[v2];
    diff[v2] = !di;
    if (height[v1] == height[v2]) height[v1]++;
  }
} uf_tree;
int n, m, q;
pair<pair<int, int>, pair<int, int> > road[N * N + 5];
int main() {
  scanf("%d %d %d", &n, &m, &q);
  for (int i = 1; i <= m; i++) {
    int v1, v2, r;
    scanf("%d %d %d", &v1, &v2, &r);
    road[i] = pair<pair<int, int>, pair<int, int> >(pair<int, int>(r, i),
                                                    pair<int, int>(v1, v2));
  }
  uf_tree.init1(n + 2);
  sort(road + 1, road + m + 1);
  for (int i = 0; i < q; i++) {
    int l, r, j;
    scanf("%d %d", &l, &r);
    uf_tree.init(n + 2);
    for (j = m; j >= 1; j--) {
      if (road[j].first.second < l || road[j].first.second > r) continue;
      int v1 = road[j].second.first, v2 = road[j].second.second;
      pair<int, bool> p1 = uf_tree.get_root(v1), p2 = uf_tree.get_root(v2);
      if (p1.first != p2.first)
        uf_tree.merge(v1, v2);
      else if (p1.second == p2.second) {
        printf("%d\n", road[j].first.first);
        break;
      }
    }
    if (j == 0) printf("-1\n");
  }
  return 0;
}
