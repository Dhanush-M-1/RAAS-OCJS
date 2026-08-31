#include <bits/stdc++.h>
using namespace std;
vector<int> vec[300005];
int par[300005], sz[300005], bit[300005], sister[300005], ans;
int find(int node) {
  if (par[node] == node) return node;
  par[node] = par[par[node]];
  return find(par[node]);
}
int Union(int a, int b) {
  if (!b) return a;
  if (sz[a] < sz[b]) swap(a, b);
  par[b] = a;
  sz[a] += sz[b];
  bit[a] = max(bit[b], bit[a]);
  return a;
}
void adjustans(int node1, int node2) {
  if (!node2) {
    if (bit[node1] == 1) ans -= sz[node1];
    return;
  }
  if (bit[node1] == -1 && bit[node2] == -1)
    ans -= min(sz[node1], sz[node2]);
  else if (bit[node1] == 1)
    ans -= sz[node1];
  else if (bit[node2] == 1)
    ans -= sz[node2];
}
void connect(int node1, int node2, bool flag) {
  int a = find(node1);
  int b = find(node2);
  if (a == b || sister[a] == b) return;
  adjustans(a, sister[a]);
  adjustans(b, sister[b]);
  int A, B;
  if (!flag) {
    A = Union(b, sister[a]);
    B = Union(a, sister[b]);
  } else {
    A = Union(a, b);
    if (!sister[a] && !sister[b]) {
      if (bit[A] == 1) ans += sz[A];
      return;
    } else if (!sister[a])
      B = Union(sister[b], sister[a]);
    else
      B = Union(sister[a], sister[b]);
  }
  sister[A] = B;
  sister[B] = A;
  if (bit[A] == -1 && bit[B] == -1)
    ans += min(sz[A], sz[B]);
  else if (bit[A] == 1 || !bit[B]) {
    bit[A] = 1;
    bit[B] = 0;
    ans += sz[A];
  } else if (!bit[A] || bit[B] == 1) {
    bit[A] = 0;
    bit[B] = 1;
    ans += sz[B];
  }
}
int main() {
  memset(bit, -1, sizeof(bit));
  int n, k, c, x;
  string str;
  cin >> n >> k;
  cin >> str;
  for (int i = 1; i <= k; ++i) {
    par[i] = i;
    sz[i] = 1;
    cin >> c;
    while (c--) {
      cin >> x;
      vec[x].push_back(i);
    }
  }
  for (int i = 1; i <= n; ++i) {
    if (vec[i].size() == 1) {
      int val = find(vec[i][0]);
      if (str[i - 1] == '0' && bit[val] == -1) {
        if (!sister[val])
          ans += sz[val];
        else {
          ans += (sz[val] - min(sz[val], sz[sister[val]]));
          bit[sister[val]] = 0;
        }
        bit[val] = 1;
      } else if (str[i - 1] == '1' && bit[val] == -1) {
        bit[val] = 0;
        if (sister[val]) {
          bit[sister[val]] = 1;
          ans += (sz[sister[val]] - min(sz[val], sz[sister[val]]));
        }
      }
    } else if (vec[i].size() == 2) {
      if (str[i - 1] == '0')
        connect(vec[i][0], vec[i][1], 0);
      else
        connect(vec[i][0], vec[i][1], 1);
    }
    printf("%d\n", ans);
  }
  return 0;
}
