#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 5;
pair<int, int> p[maxn];
int n;
long long d[maxn];
long long e[maxn];
void add(long long *c, int i, int k) {
  while (i <= n) {
    c[i] += k;
    i += i & (-i);
  }
}
long long sum(long long *c, int i) {
  long long res = 0;
  while (i > 0) {
    res += c[i];
    i -= i & (-i);
  }
  return res;
}
int main() {
  cin >> n;
  for (int i = 0; i <= n - 1; i++) cin >> p[i].first;
  for (int i = 0; i <= n - 1; i++) cin >> p[i].second;
  sort(p, p + n);
  vector<int> es(n);
  for (int i = 0; i <= n - 1; i++) es[i] = p[i].second;
  sort(es.begin(), es.end());
  long long res = 0;
  for (int i = 0; i <= n - 1; i++) {
    int pp = lower_bound(es.begin(), es.end(), p[i].second) - es.begin() + 1;
    res += sum(d, pp) * p[i].first - sum(e, pp);
    add(d, pp, 1);
    add(e, pp, p[i].first);
  }
  cout << res << "\n";
}
