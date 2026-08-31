#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
long long a[maxn];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(nullptr);
  int n;
  long long d;
  cin >> n >> d;
  multiset<long long> box;
  long long pref = 0LL;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    pref += a[i];
    box.insert(pref);
  }
  long long cur = 0;
  long long add = 0;
  long long cnt = 0;
  pref = 0;
  for (int i = 0; i < n; ++i) {
    cur += a[i];
    if (cur > d) {
      cout << -1;
      return 0;
    }
    if (a[i] == 0 && cur < 0LL) {
      long long mx = *box.rbegin();
      mx += add;
      long long curadd = d - mx;
      if (cur + curadd < 0) {
        cout << -1;
        return 0;
      }
      cnt++;
      cur += curadd;
      add += curadd;
    }
    pref += a[i];
    box.erase(box.find(pref));
  }
  cout << cnt;
  return 0;
}
