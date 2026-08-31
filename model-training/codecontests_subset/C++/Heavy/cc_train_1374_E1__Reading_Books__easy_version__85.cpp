#include <bits/stdc++.h>
const int maxn = 2e6 + 1;
const int maxm = 1e5 + 10;
const long long int mod = 1e9 + 7;
const long long int INF = 1e18 + 100;
const int inf = 0x3f3f3f3f;
const double pi = acos(-1.0);
const double eps = 1e-8;
using namespace std;
multiset<long long int> va, vb, vall;
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) {
    long long int t;
    int a, b;
    scanf("%lld %d %d", &t, &a, &b);
    if (a == 0 && b == 0)
      continue;
    else if (a == 1 && b == 0)
      va.insert(t);
    else if (a == 0 && b == 1)
      vb.insert(t);
    else
      vall.insert(t);
  }
  long long int ans = 0;
  while (m--) {
    if ((int)vall.size() != 0 && (int)va.size() != 0 && (int)vb.size() != 0) {
      if (*vall.begin() > *va.begin() + *vb.begin()) {
        ans += *va.begin() + *vb.begin();
        va.erase(va.begin());
        vb.erase(vb.begin());
      } else {
        ans += *vall.begin();
        vall.erase(vall.begin());
      }
    } else if ((int)vall.size() != 0)
      ans += *vall.begin(), vall.erase(vall.begin());
    else if ((int)va.size() != 0 && (int)vb.size() != 0) {
      ans += *va.begin() + *vb.begin();
      va.erase(va.begin());
      vb.erase(vb.begin());
    } else
      break;
  }
  if (m >= 0)
    puts("-1");
  else
    printf("%lld\n", ans);
}
