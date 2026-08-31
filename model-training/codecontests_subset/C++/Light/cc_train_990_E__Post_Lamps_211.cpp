#include <bits/stdc++.h>
using namespace std;
const int N = 1e5;
long long int n;
long long int ox[1000010];
long long int kh[1000010];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int n, m, k;
  cin >> n >> m >> k;
  long long int s[m + 1];
  long long int a[k + 1];
  for (int i = 1; i <= m; i++) {
    cin >> s[i];
  }
  for (int i = 1; i <= k; i++) {
    cin >> a[i];
  }
  for (int i = 1; i <= m; i++) {
    ox[s[i]] = 1;
  }
  if (ox[0]) {
    cout << -1 << '\n';
    return 0;
  }
  sort(s + 1, s + m + 1);
  long long int cons = 0, temp = 1;
  for (int i = 2; i <= m; i++) {
    if (s[i] != s[i - 1] + 1) {
      cons = max(temp, cons);
      temp = 1;
    } else {
      temp++;
    }
  }
  cons = max(cons, temp);
  if (m == 0) {
    cons = 0;
  }
  int kh1 = 0;
  for (int i = 0; i <= n; i++) {
    if (ox[i] == 1) {
      kh[i] = kh1;
    } else {
      kh1 = i;
      kh[i] = i;
    }
  }
  long long int ans = 1e18;
  for (int i = 1; i <= k; i++) {
    if (i <= cons) {
      continue;
    }
    long long int temp = 0;
    for (int j = 0; j < n; j += (i)) {
      if (ox[j] == 0) {
        temp++;
      } else {
        j = kh[j];
        temp++;
      }
    }
    ans = min(a[i] * temp, ans);
  }
  if (ans == 1e18) {
    cout << -1 << '\n';
    return 0;
  } else {
    cout << ans << '\n';
  }
  return 0;
}
