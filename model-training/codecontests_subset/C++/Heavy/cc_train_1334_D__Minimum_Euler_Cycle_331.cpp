#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline T abs(T t) {
  return t < 0 ? -t : t;
}
const long long modn = 1000000007;
inline long long mod(long long x) { return x % modn; }
const int MAXN = 212345;
int n, m, k;
long long l, r;
int s[MAXN];
vector<int> ans;
long long stp;
void add(int x) {
  if (stp >= l && stp <= r) ans.push_back(x);
  stp++;
}
int main() {
  int t;
  scanf("%d", &t);
  for (int tt = 1; tt <= t; tt++) {
    ans.clear();
    scanf("%d%lld%lld", &n, &l, &r);
    stp = 1;
    int look = 2;
    while (look < n) {
      add(1);
      add(look);
      look++;
    }
    add(1);
    add(n);
    int base = 2;
    while (base < n) {
      add(base);
      if (stp > r) break;
      if (stp + 2ll * (n - 1 - base - 1 + 1) >= l) {
        for (int o = base + 1; o < n; o++) {
          add(o);
          add(base);
        }
      } else {
        stp += (long long)2ll * (n - 1 - base - 1 + 1);
      }
      add(n);
      base++;
    }
    add(1);
    for (int x : ans) printf("%d ", x);
    puts("");
  }
}
