#include <bits/stdc++.h>
using namespace std;
const long long mod = 998244353;
const int maxn = 1e6 + 10;
const double eps = 1e-9;
const long long inf = 1e18;
int T;
int n, m, k;
vector<long long> vec[5];
long long a, b, t;
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) {
    scanf("%lld%lld%lld", &t, &a, &b);
    if (a && b)
      vec[1].push_back(t);
    else if (a && !b)
      vec[2].push_back(t);
    else if (!a && b)
      vec[3].push_back(t);
    else
      vec[4].push_back(t);
  }
  for (int i = 1; i <= 4; i++) sort(vec[i].begin(), vec[i].end());
  int flag = 1;
  a = b = 0;
  int l1 = vec[1].size(), l2 = min(vec[2].size(), vec[3].size());
  long long ans = 0;
  for (int i = 1; i <= k; i++) {
    if (l1 == a && l2 == b) {
      flag = 0;
      break;
    }
    if (l1 == a || (l2 != b && vec[1][a] >= vec[2][b] + vec[3][b])) {
      ans += vec[2][b] + vec[3][b];
      b++;
    } else {
      ans += vec[1][a];
      a++;
    }
  }
  if (flag)
    printf("%lld\n", ans);
  else
    printf("-1\n");
  return 0;
}
