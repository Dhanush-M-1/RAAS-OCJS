#include <bits/stdc++.h>
using namespace std;
const long long mod = 998244353;
const int N = 2e5 + 2;
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    long long n, l, r;
    scanf("%lld", &n);
    scanf("%lld", &l);
    scanf("%lld", &r);
    long long cur = 0, val = 2 * (n - 1), ind = 1;
    while (cur + val < l) {
      cur += val;
      val /= 2;
      val--;
      val *= 2;
      ind++;
      if (ind == n) val = 1;
    }
    long long total = n * (n - 1) + 1;
    long long ptr = cur + 1;
    long long x = ind, y = x + 1;
    vector<pair<long long, long long> > v;
    while (ptr <= r) {
      if (ptr == total) {
        v.push_back({1, ptr});
        break;
      }
      v.push_back({x, ptr});
      v.push_back({y, ptr + 1});
      ptr += 2;
      y++;
      if (y > n) {
        x++;
        y = x + 1;
        if (x == n) {
          v.push_back({1, ptr});
          break;
        }
      }
    }
    for (auto i : v)
      if (i.second >= l && i.second <= r) printf("%d ", (int)i.first);
    printf("\n");
  }
  return 0;
}
