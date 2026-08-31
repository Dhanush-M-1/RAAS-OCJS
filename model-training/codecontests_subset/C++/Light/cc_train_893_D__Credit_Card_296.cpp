#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int a[N];
long long pref[N];
int main() {
  int n, d;
  cin >> n >> d;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    if (i)
      pref[i] += pref[i - 1] + a[i];
    else
      pref[i] += a[i];
  }
  int ans = 0;
  long long mini = 0, maxi = 0;
  for (int i = 0; i < n; ++i) {
    if (!a[i]) {
      if (pref[i] + mini >= 0)
        continue;
      else
        mini = -pref[i];
      if (pref[i] + maxi < 0) {
        ans++;
        maxi = d - pref[i];
      }
    }
    if (pref[i] + mini > d) return cout << -1, 0;
    if (pref[i] + maxi > d) maxi = d - pref[i];
  }
  cout << ans;
  return 0;
}
