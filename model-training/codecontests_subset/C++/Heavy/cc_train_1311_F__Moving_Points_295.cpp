#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10, mod = 1e9 + 7, INF = 0x3f3f3f3f;
long long fwk[maxn], cnt[maxn];
void upd(int p, int c) {
  for (; p < maxn; p += p & -p) fwk[p] += c, cnt[p]++;
}
void qry(int p, long long& sum, long long& c) {
  sum = c = 0;
  for (; p; p -= p & -p) sum += fwk[p], c += cnt[p];
}
vector<int> d;
inline int hs(int x) {
  return lower_bound(d.begin(), d.end(), x) - d.begin() + 1;
}
pair<int, int> p[maxn];
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; ++i) scanf("%d", &p[i].first);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &p[i].second);
    d.push_back(p[i].second);
  }
  sort(p + 1, p + 1 + n);
  sort(d.begin(), d.end());
  d.erase(unique(d.begin(), d.end()), d.end());
  long long ans = 0, sum, c;
  for (int i = 1; i <= n; ++i) {
    qry(hs(p[i].second), sum, c);
    ans += c * p[i].first - sum;
    upd(hs(p[i].second), p[i].first);
  }
  cout << ans;
  return 0;
}
