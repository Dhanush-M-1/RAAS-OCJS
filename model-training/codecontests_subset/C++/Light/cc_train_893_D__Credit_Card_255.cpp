#include <bits/stdc++.h>
using namespace std;
long long A[100010], B[100010], maxi[100010];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int n, d;
  cin >> n >> d;
  for (int i = 0; i < n; i++) cin >> A[i];
  B[0] = A[0];
  if (A[0] > d) {
    cout << -1 << '\n';
    return 0;
  }
  for (int i = 1; i < n; i++) {
    B[i] += B[i - 1] + A[i];
    if (B[i] > d) {
      cout << -1 << '\n';
      return 0;
    }
  }
  maxi[n - 1] = B[n - 1];
  for (int i = n - 2; i >= 0; i--) {
    maxi[i] = max(maxi[i + 1], B[i]);
  }
  long long cur = 0, add = 0;
  int ans = 0;
  for (int i = 0; i < n; i++) {
    if (A[i] == 0) {
      if (cur < 0) {
        long long val = maxi[i] + add;
        long long rem = d - val;
        if (rem > 0 && cur + rem >= 0) {
          add += rem;
          ans++;
          cur += rem;
        } else {
          cout << -1 << '\n';
          return 0;
        }
      }
    } else {
      cur += A[i];
    }
  }
  cout << ans << '\n';
}
