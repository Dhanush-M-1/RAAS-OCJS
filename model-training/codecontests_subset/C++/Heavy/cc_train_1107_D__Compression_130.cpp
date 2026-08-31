#include <bits/stdc++.h>
using namespace std;
int a[5222][5222], ans, n, psum[5222][5222];
vector<int> v;
int cal(int sx, int ex, int sy, int ey) {
  return psum[ex][ey] - psum[ex][sy - 1] - psum[sx - 1][ey] +
         psum[sx - 1][sy - 1];
}
int sol(int x) {
  for (int i = 0; i < n / x; i++) {
    int sx = i * x + 1;
    int ex = i * x + x;
    for (int j = 0; j < n / x; j++) {
      int sy = j * x + 1;
      int ey = j * x + x;
      if (cal(sx, ex, sy, ey) != a[i * x + 1][j * x + 1] * x * x) {
        return 0;
      }
    }
  }
  return 1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    string s;
    cin >> s;
    int idx = 1;
    for (int j = 0; j < s.size(); j++) {
      int cur = 0;
      if (s[j] >= 'A' && s[j] <= 'F') {
        cur = s[j] - 'A' + 10;
      } else {
        cur = s[j] - '0';
      }
      for (int j = 3; j >= 0; j--) {
        if ((1 << j) & cur) {
          a[i][idx] = 1;
        }
        idx++;
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      psum[i][j] =
          psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + a[i][j];
    }
  }
  long long sq = sqrt(n);
  for (int i = 1; i <= sq; i++) {
    if (n % i == 0) {
      v.push_back(i);
      if (n / i != i) {
        v.push_back(n / i);
      }
    }
  }
  for (int i = 0; i < v.size(); i++) {
    if (sol(v[i])) {
      ans = max(ans, v[i]);
    }
  }
  cout << ans;
}
