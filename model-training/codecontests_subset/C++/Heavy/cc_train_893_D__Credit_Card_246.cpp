#include <bits/stdc++.h>
using namespace std;
using lli = long long int;
using ll = lli;
using llu = unsigned long long int;
using pii = tuple<lli, lli>;
using piii = tuple<lli, lli, lli>;
using vi = vector<lli>;
using vii = vector<pii>;
using viii = vector<piii>;
using vvi = vector<vi>;
using vvii = vector<vii>;
using vviii = vector<viii>;
using vb = vector<bool>;
using vvb = vector<vb>;
int main() {
  int n, d;
  scanf("%d%d", &n, &d);
  vi a(n);
  for (lli i = 0; i < (lli)(n); ++i) scanf("%lld", &a[i]);
  vi ca(n + 1);
  for (lli i = (lli)(1); i < (lli)(n + 1); ++i) ca[i] = ca[i - 1] + a[i - 1];
  vi mca(n + 1);
  mca[n] = ca[n];
  for (lli i = (lli)(n)-1; i >= (lli)(0); --i) mca[i] = max(ca[i], mca[i + 1]);
  int ans = 0;
  lli S = 0, add = 0;
  for (lli i = 0; i < (lli)(n); ++i) {
    if (a[i] == 0 && S < 0) {
      lli v = d - (mca[i] + add);
      S += v;
      add += v;
      if (S < 0) {
        puts("-1");
        return 0;
      }
      ans++;
    }
    S += a[i];
    if (S > d) {
      puts("-1");
      return 0;
    }
  }
  printf("%d\n", ans);
}
