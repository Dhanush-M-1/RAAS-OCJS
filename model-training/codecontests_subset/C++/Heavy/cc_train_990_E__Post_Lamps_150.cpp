#include <bits/stdc++.h>
using namespace std;
const double PI =
    3.141592653589793238462643383279502884197169399375105820974944;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long ans = 1000000000;
  ans *= 10000000;
  long long tempans = ans;
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, m, k;
  cin >> n >> m >> k;
  int s[m + 1];
  for (int i = 0; i < m; i++) cin >> s[i];
  s[m] = n + 5;
  int a[k + 1];
  for (int i = 1; i <= k; i++) cin >> a[i];
  int haha[n], curr = 0;
  for (int i = 0; i < n; i++) {
    if (s[curr] == i) {
      haha[i] = 0;
      curr++;
    } else
      haha[i] = 1;
  }
  if (haha[0] == 0) {
    cout << -1 << endl;
    return 0;
  }
  int prev[n];
  prev[0] = 0;
  for (int i = 1; i < n; i++) {
    if (haha[i] == 1)
      prev[i] = i;
    else
      prev[i] = prev[i - 1];
  }
  for (int i = 1; i <= k; i++) {
    long long cnt = 0, check = 1;
    int pos = 0, temppos;
    while (pos < n) {
      temppos = prev[pos];
      temppos += i;
      if (temppos <= pos) {
        check = 0;
        break;
      }
      pos = temppos;
      cnt++;
    }
    if (check) ans = min(ans, cnt * a[i]);
  }
  if (ans != tempans)
    cout << ans;
  else
    cout << -1;
}
