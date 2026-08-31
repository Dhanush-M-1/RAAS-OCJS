#include <bits/stdc++.h>
using namespace std;
long long a, b;
vector<long long> treea, treeb;
void build(int node, int s, int e) {
  if (s == e) {
    treea[node] = 0;
    treeb[node] = 0;
  } else {
    build(2 * node, s, (s + e) / 2);
    build(2 * node + 1, (s + e) / 2 + 1, e);
    treea[node] = treea[node * 2] + treea[node * 2 + 1];
    treeb[node] = treeb[node * 2] + treeb[node * 2 + 1];
  }
}
void update(int node, int s, int e, int idx, int val) {
  if (s == e) {
    treea[node] += val;
    treea[node] = min(treea[node], a);
    treeb[node] += val;
    treeb[node] = min(treeb[node], b);
  } else {
    if (s <= idx && idx <= (s + e) / 2)
      update(2 * node, s, (s + e) / 2, idx, val);
    else
      update(2 * node + 1, (s + e) / 2 + 1, e, idx, val);
    treea[node] = treea[node * 2] + treea[node * 2 + 1];
    treeb[node] = treeb[node * 2] + treeb[node * 2 + 1];
  }
}
long long querya(int node, int s, int e, int l, int r) {
  if (r < s || e < l || l > r) return 0;
  if (l <= s && e <= r) return treea[node];
  long long a = querya(2 * node, s, (s + e) / 2, l, r);
  a += querya(2 * node + 1, (s + e) / 2 + 1, e, l, r);
  return a;
}
long long queryb(int node, int s, int e, int l, int r) {
  if (r < s || e < l || l > r) return 0;
  if (l <= s && e <= r) return treeb[node];
  long long a = queryb(2 * node, s, (s + e) / 2, l, r);
  a += queryb(2 * node + 1, (s + e) / 2 + 1, e, l, r);
  return a;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, k, q;
  cin >> n >> k >> a >> b >> q;
  treea.resize(4 * n + 1);
  treeb.resize(4 * n + 1);
  while (q--) {
    int t, f;
    cin >> t;
    if (t == 1) {
      cin >> t >> f;
      update(1, 0, n - 1, t - 1, f);
    } else {
      cin >> t;
      t--;
      cout << queryb(1, 0, n - 1, 0, t - 1) + querya(1, 0, n - 1, t + k, n - 1)
           << "\n";
    }
  }
}
