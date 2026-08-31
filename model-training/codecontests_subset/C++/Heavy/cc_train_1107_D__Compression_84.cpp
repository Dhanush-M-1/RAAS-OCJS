#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, x;
  cin >> n;
  string s;
  vector<vector<bool>> a(n, vector<bool>(n, false));
  for (int i = 0; i < n; i++) {
    cin >> s;
    for (int j = 0; j < s.size(); j++) {
      if (isalpha(s[j])) {
        x = s[j] - 'A' + 10;
      } else {
        x = s[j] - '0';
      }
      for (int k = 3; k >= 0; k--) {
        a[i][j * 4 + k] = (x % 2 == 1);
        x /= 2;
      }
    }
  }
  int ans = 0;
  vector<vector<int>> sum(n + 1, vector<int>(n + 1, 0));
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
      sum[i][j] += a[i - 1][j - 1];
    }
  }
  vector<int> div;
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      div.push_back(i);
      if (i * i != n) {
        div.push_back(n / i);
      }
    }
  }
  sort(div.begin(), div.end());
  int m, d, tot;
  bool valid;
  int ss1, ss2, ee1, ee2;
  for (int ii = div.size() - 1; ii >= 0; ii--) {
    m = div[ii];
    d = n / m;
    valid = true;
    for (int i = 0; valid && i < n; i += m) {
      for (int j = 0; j < n; j += m) {
        ss1 = i;
        ss2 = i + m - 1;
        ee1 = j;
        ee2 = j + m - 1;
        tot = sum[ss2 + 1][ee2 + 1];
        tot -= sum[ss1][ee2 + 1];
        tot -= sum[ss2 + 1][ee1];
        tot += sum[ss1][ee1];
        if ((tot != m * m) && (tot != 0)) {
          valid = false;
          break;
        }
      }
    }
    if (valid) {
      cout << m << endl;
      return;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
