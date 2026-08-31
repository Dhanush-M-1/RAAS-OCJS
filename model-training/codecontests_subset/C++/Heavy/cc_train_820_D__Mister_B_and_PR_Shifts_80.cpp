#include <bits/stdc++.h>
using namespace std;
const long double pi = 3.141592653589793;
int n;
long long P[1 << 20];
long long H[1 << 20];
void update(int i, int j, int inr) {
  H[i] += inr;
  H[j + 1] -= inr;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  long long val = 0, which = 0;
  for (int i = 0; i < n; i++) cin >> P[i + 1];
  for (int k = 1; k <= n; k++) {
    val += abs(P[k] - k);
    if (P[k] >= k) {
      int s = 1, diff;
      diff = P[k] - k;
      if (diff > 0) {
        update(s, s + diff - 1, -1);
        s = s + diff;
      }
      if (s == n) continue;
      diff = (n - P[k]);
      if (diff > 0) {
        update(s, s + diff - 1, 1);
        s = s + diff;
      }
      if (s == n) continue;
      diff = 1;
      if (n - 2 * P[k] + 1 > 0)
        update(s, s + diff - 1, -(n - 2 * P[k] + 1));
      else
        update(s, s + diff - 1, -(n - 2 * P[k] + 1));
      s = s + diff;
      if (s == n) continue;
      if (k - 2 > 0) update(s, n - 1, -1);
    } else {
      int s = 1, diff;
      diff = n - k;
      if (diff > 0) {
        update(s, s + diff - 1, 1);
        s = s + diff;
      }
      if (s == n) continue;
      diff = 1;
      if (n - 2 * P[k] + 1 > 0)
        update(s, s + diff - 1, -(n - 2 * P[k] + 1));
      else
        update(s, s + diff - 1, -(n - 2 * P[k] + 1));
      s = s + diff;
      if (s == n) continue;
      diff = (P[k] - 1);
      if (diff > 0) {
        update(s, s + diff - 1, -1);
        s = s + diff;
      }
      if (s == n) continue;
      if (k - 1 - P[k] > 0) update(s, n - 1, 1);
    }
  }
  for (int i = 1; i < n; i++) H[i] += H[i - 1];
  long long ans = val;
  for (int i = 1; i < n; i++) {
    val = val + H[i];
    if (val < ans) {
      ans = val;
      which = i;
    }
  }
  cout << ans << " " << which << endl;
  return 0;
}
