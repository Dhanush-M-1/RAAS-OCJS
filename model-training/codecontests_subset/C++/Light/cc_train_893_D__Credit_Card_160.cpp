#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 1e5 + 5;
int n, d;
int a[MAX_N];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> d;
  for (int i = 0; i < n; i++) cin >> a[i];
  int ans = 0;
  long long s = 0, e = 0;
  for (int i = 0; i < n; i++) {
    s += a[i];
    if (s > d) {
      ans = -1;
      break;
    }
    if (s + e > d) e = d - s;
    if (a[i] == 0 && s < 0) {
      if (s + e < 0) {
        s = 0;
        e = d;
        ans++;
      } else {
        e = s + e;
        s = 0;
      }
    }
  }
  cout << ans << "\n";
  return 0;
}
