#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
const int mod = 1e9 + 7;
struct ac {
  long long a, b, t;
};
ac a[maxn];
bool cmp1(ac a, ac b) { return a.t < b.t; }
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  vector<long long> suma, sumb, sumab;
  suma.push_back(0), sumb.push_back(0), sumab.push_back(0);
  int f1 = 0, f2 = 0;
  int n, k;
  cin >> n >> k;
  int cntab = 0;
  int cnta = 0;
  int cntb = 0;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].t >> a[i].a >> a[i].b;
    if (a[i].a && a[i].b) cntab++;
    if (a[i].a && a[i].b == 0) cnta++;
    if (a[i].a == 0 && a[i].b) cntb++;
    if (a[i].a) f1++;
    if (a[i].b) f2++;
  }
  if (f1 < k || f2 < k) {
    cout << -1 << '\n';
    return 0;
  }
  long long ans = 1e15;
  sort(a + 1, a + 1 + n, cmp1);
  int ra = 0;
  int rb = 0;
  int rab = 0;
  for (int i = 1; i <= n; i++) {
    if (a[i].a && a[i].b == 0) {
      long long temp = suma[ra++] + a[i].t;
      suma.push_back(temp);
    }
    if (a[i].a == 0 && a[i].b) {
      long long temp = sumb[rb++] + a[i].t;
      sumb.push_back(temp);
    }
    if (a[i].a && a[i].b) {
      long long temp = sumab[rab++] + a[i].t;
      sumab.push_back(temp);
    }
  }
  for (int i = 0; i <= cntab; i++) {
    if (i > k) break;
    long long temp = sumab[i];
    if (k - i > cnta) continue;
    temp += suma[k - i];
    if (k - i > cntb) continue;
    temp += sumb[k - i];
    ans = min(ans, temp);
  }
  cout << ans << '\n';
}
