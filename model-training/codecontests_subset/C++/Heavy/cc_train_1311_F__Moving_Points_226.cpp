#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int bit[N];
void add(int p, int v) {
  for (p += 2; p < N; p += p & -p) bit[p] += v;
}
long long query(int p) {
  int r = 0;
  for (p += 2; p; p -= p & -p) r += bit[p];
  return r;
}
int n;
pair<int, int> p[N];
long long l[N], r[N];
int ql[N], qr[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> p[i].second;
  for (int i = 1; i <= n; i++) cin >> p[i].first;
  sort(p + 1, p + n + 1);
  map<int, int> id;
  int cnt = 0, last = 0x3f3f3f3f;
  for (int i = 1; i <= n; i++) {
    int v = p[i].first;
    if (v != last) id[v] = ++cnt, last = v;
    swap(p[i].first, p[i].second);
  }
  sort(p + 1, p + n + 1);
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    long long x = p[i].first, v = id[p[i].second];
    ans += query(v) * x;
    add(v, 1);
  }
  memset(bit, 0, sizeof(bit));
  for (int i = n; i >= 1; i--) {
    long long x = p[i].first, v = id[p[i].second];
    ans -= (query(n) - query(v - 1)) * x;
    add(v, 1);
  }
  cout << ans << '\n';
}
