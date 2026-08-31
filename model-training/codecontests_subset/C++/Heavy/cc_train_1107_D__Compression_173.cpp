#include <bits/stdc++.h>
using namespace std;
long long a[5205][5205];
bool check(long long i, long long j, long long k) {
  k--;
  long long act =
      a[i + k][j + k] - a[i - 1][j + k] - a[i + k][j - 1] + a[i - 1][j - 1];
  k++;
  if (act == k * k || act == 0) return 1;
  return 0;
}
bool verif(long long n, long long ans) {
  long long i, j;
  for (i = 1; i <= n - ans + 1; i += ans)
    for (j = 1; j <= n - ans + 1; j += ans)
      if (!check(i, j, ans)) return 0;
  return 1;
}
vector<long long> divv[5205];
int main() {
  ios_base::sync_with_stdio(false);
  char x;
  long long i, j, nr, ind2, n, k, ans;
  cin >> n;
  for (i = 2; i <= n; i++) {
    for (j = i; j <= n; j += i) divv[j].push_back(i);
  }
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= n / 4; j++) {
      cin >> x;
      if (x >= '0' && x <= '9')
        nr = x - '0';
      else
        nr = x - 'A' + 10;
      for (k = 1; k <= 4; k++) {
        ind2 = (j - 1) * 4 + k;
        a[i][ind2] = (nr & 8) / 8;
        a[i][ind2] += a[i - 1][ind2] + a[i][ind2 - 1] - a[i - 1][ind2 - 1];
        nr = nr << 1;
      }
    }
  }
  for (long long ind = divv[n].size() - 1; ind >= 0; ind--) {
    ans = divv[n][ind];
    if (verif(n, ans)) {
      cout << ans << '\n';
      return 0;
    }
  }
  cout << 1 << '\n';
  return 0;
}
