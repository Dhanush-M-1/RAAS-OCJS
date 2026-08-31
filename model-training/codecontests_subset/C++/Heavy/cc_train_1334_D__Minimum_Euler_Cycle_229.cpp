#include <bits/stdc++.h>
using namespace std;
long long l, r;
int n;
vector<long long> a;
int main() {
  int tt;
  scanf("%d", &tt);
  while (tt--) {
    a.clear();
    scanf("%d%lld%lld", &n, &l, &r);
    long long sum = 0, pos1 = 0;
    for (int i = 1; i <= n; i++) {
      if (1 + sum <= l && 1ll * (n - i) * 2 + sum >= l) {
        pos1 = i;
        break;
      } else
        sum = sum + 1ll * (n - i) * 2;
    }
    if (l == 1ll * n * (n - 1) + 1)
      a.push_back(1);
    else {
      while (l <= r) {
        if (l % 2)
          a.push_back(pos1);
        else {
          long long t = l - sum - 1;
          t = pos1 + (t + 1) / 2;
          a.push_back(t);
        }
        l++;
        if (l > r) break;
        if (l > (1ll * n - pos1) * 2 + sum) {
          sum = sum + (1ll * n - pos1) * 2;
          pos1++;
        }
        if (l == 1ll * n * (n - 1) + 1) {
          a.push_back(1);
          break;
        }
      }
    }
    int cnt = a.size();
    for (int i = 0; i < cnt - 1; i++) printf("%lld ", a[i]);
    printf("%lld\n", a[cnt - 1]);
  }
  return 0;
}
