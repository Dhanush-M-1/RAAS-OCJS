#include <bits/stdc++.h>
#pragma GCC optimize(2)
using namespace std;
using ll = long long;
using ull = unsigned long long;
using pli = pair<ll, int>;
using pii = pair<int, int>;
constexpr ll mod = 1e9 + 7;
constexpr int N = 200010;
struct node {
  ll x;
  int v, id;
  bool operator<(const node &o) const { return x < o.x; }
} q[N];
int n, nn, b[N];
ll fw[2][N];
int lowbit(int x) { return x & -x; }
void update(int op, int k, int x) {
  for (; k <= n; k += lowbit(k)) fw[op][k] += x;
}
ll query(int op, int k) {
  ll res = 0;
  for (; k; k -= lowbit(k)) res += fw[op][k];
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  int T = 1;
  while (T--) {
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> q[i].x;
    for (int i = 1; i <= n; i++) {
      cin >> q[i].v;
      b[i] = q[i].v;
      q[i].id = i;
    }
    sort(b + 1, b + 1 + n);
    nn = unique(b + 1, b + 1 + n) - b - 1;
    for (int i = 1; i <= n; i++)
      q[i].v = lower_bound(b + 1, b + 1 + nn, q[i].v) - b;
    sort(q + 1, q + 1 + n);
    ll res = 0;
    for (int i = 1; i <= n; i++) {
      res += q[i].x * query(0, q[i].v) - query(1, q[i].v);
      update(0, q[i].v, 1);
      update(1, q[i].v, q[i].x);
    }
    cout << res << '\n';
  }
  return 0;
}
