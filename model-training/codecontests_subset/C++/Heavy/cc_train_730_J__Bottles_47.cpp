#include <bits/stdc++.h>
using namespace std;
const int inf = INT_MAX;
const unsigned long long INF = LLONG_MAX;
const unsigned long long mod = 1e9 + 7;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  int n;
  cin >> n;
  vector<int> a(n);
  unsigned long long t1 = 0, t2 = 0;
  for (int i = 0; i <= n - 1; i++) {
    cin >> a[i];
    t1 += a[i];
  }
  vector<int> b(n);
  for (int i = 0; i <= n - 1; i++) {
    cin >> b[i];
    t2 += b[i];
  }
  vector<long long int> vfilled(10001, -INF);
  vector<long long int> num(10001, INF);
  num[0] = 0;
  vfilled[0] = 0;
  for (int i = 0; i <= n - 1; i++) {
    for (int j = 10000 - b[i]; j >= 0; j--) {
      if (num[j] != INF) {
        if (num[j + b[i]] > num[j] + 1) {
          num[j + b[i]] = num[j] + 1;
          vfilled[j + b[i]] = vfilled[j] + a[i];
        } else if (num[j + b[i]] == num[j] + 1) {
          vfilled[j + b[i]] = max(vfilled[j + b[i]], vfilled[j] + a[i]);
        }
      }
    }
  }
  unsigned long long count = INF, ans = INF;
  for (long long int i = t1; i <= 10000; i++) {
    if (num[i] < count) {
      count = num[i];
      ans = t1 - vfilled[i];
    } else if (num[i] == count) {
      unsigned long long current = i;
      ans = min(ans, t1 - vfilled[i]);
    }
  }
  cout << count << " " << ans;
  return 0;
}
