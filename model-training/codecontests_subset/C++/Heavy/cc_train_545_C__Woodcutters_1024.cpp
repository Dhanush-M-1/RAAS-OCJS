#include <bits/stdc++.h>
using namespace std;
const long long INF = 1 << 28;
const long long LINF = 1ll << 61;
long long n, pos, ans;
pair<long long, long long> a[100111];
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i].first >> a[i].second;
  sort(a + 1, a + 1 + n);
  pos = -LINF;
  for (int i = 1; i <= n; i++) {
    if (a[i].first - a[i].second > pos &&
        (i == 1 || a[i].first - a[i].second > a[i - 1].first))
      ans++, pos = a[i].first;
    if (a[i].first > pos &&
        (i == n || a[i].first + a[i].second < a[i + 1].first))
      ans++, pos = a[i].first + a[i].second;
  }
  cout << ans << endl;
  return 0;
}
