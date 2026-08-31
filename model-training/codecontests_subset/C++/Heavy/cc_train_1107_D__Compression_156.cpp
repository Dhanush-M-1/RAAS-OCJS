#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
void solve() {
  long long n;
  cin >> n;
  vector<long long> fac;
  long long i = 1;
  while (i * i <= n) {
    if (n % i == 0) {
      fac.push_back(i);
      if (i * i == n) {
        i++;
        continue;
      }
      fac.push_back(n / i);
    }
    i++;
  }
  long long a[n + 5][n + 5];
  memset(a, 0, sizeof(a));
  for (int i = 1; i < n + 1; i++) {
    string s;
    cin >> s;
    int n1 = s.size();
    int id = n;
    for (int j = n1 - 1; j >= 0; j--) {
      long long val1 = s[j] - '0';
      if (s[j] >= 'A') val1 = s[j] - 'A' + 10;
      int val2 = 4;
      while (val2--) {
        a[i][id--] = (val1 & 1);
        val1 /= 2;
      }
    }
  }
  set<long long> s;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      s.insert(a[i][j]);
    }
  }
  if (s.size() == 1) {
    cout << n << "\n";
  } else {
    long long ans = 1;
    for (auto ele : fac) {
      if (ele == n) continue;
      map<pair<long long, long long>, long long> v;
      long long x = ele;
      int flag = 1;
      for (int i = 1; i <= n / x; i++) {
        for (int j = 1; j <= n / x; j++) {
          for (int k = 1; k <= x; k++) {
            for (int l = 1; l <= x; l++) {
              if (a[(i - 1) * x + k][(j - 1) * x + l] != a[i * x][j * x])
                flag = 0;
            }
          }
        }
      }
      if (flag) ans = max(ans, ele);
    }
    cout << ans << "\n";
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int tc = 1;
  while (tc--) solve();
  return 0;
}
