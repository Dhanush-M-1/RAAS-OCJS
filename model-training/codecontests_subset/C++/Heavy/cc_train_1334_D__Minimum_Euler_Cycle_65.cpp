#include <bits/stdc++.h>
using namespace std;
long long cnt[100006];
vector<int> ans;
int main() {
  int tests = 1;
  int n;
  long long l, r;
  scanf("%d", &tests);
  while (tests--) {
    ans.clear();
    scanf("%d%lld%lld", &n, &l, &r);
    for (int i = 1; i < n; ++i) cnt[i] = 1ll * (2 * n - i - 1) * i;
    int s = 0, t = 0, f = 0;
    if (r == 1ll * n * (n - 1) + 1) f = 1;
    for (int i = 1; i < n; ++i) {
      if (cnt[i] < l) s = i;
      if (cnt[i] <= r) t = i;
    }
    s++;
    t++;
    for (int i = s; i <= t; ++i) {
      for (int j = i + 1; j <= n; ++j) ans.push_back(i), ans.push_back(j);
    }
    r -= cnt[s - 1] + 1, l -= cnt[s - 1] + 1;
    for (int i = 0; i < (int)ans.size(); ++i) {
      if (i >= l && i <= r) printf("%d ", ans[i]);
    }
    if (f) printf("1");
    puts("");
  }
}
