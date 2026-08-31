#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200200;
int n;
long long ans, bit[2][MAXN];
pair<int, int> a[MAXN];
void compress() {
  map<int, int> m;
  for (int i = 1; i <= n; ++i) m[a[i].second];
  int cnt = 1;
  for (auto& [key, val] : m) val = cnt++;
  for (int i = 1; i <= n; ++i) a[i].second = m[a[i].second];
}
void add(int b, int pos, int val) {
  for (; 0 < pos && pos < MAXN; pos += pos & -pos) bit[b][pos] += val;
}
long long get(int b, int pos) {
  long long ret = 0;
  for (; 0 < pos && pos < MAXN; pos -= pos & -pos) ret += bit[b][pos];
  return ret;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i].first);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i].second);
  sort(a + 1, a + n + 1);
  compress();
  for (int i = 1; i <= n; ++i) {
    auto [x, v] = a[i];
    ans += 1LL * x * get(0, v) - get(1, v);
    add(1, v, x);
    add(0, v, 1);
  }
  printf("%lld\n", ans);
}
