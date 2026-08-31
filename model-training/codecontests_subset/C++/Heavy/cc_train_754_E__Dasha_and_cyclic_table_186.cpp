#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = double;
using cd = complex<ld>;
const long double PI = acosl(-1);
const long double EPS = 1e-6;
void dft(vector<cd>& a, bool invert = false) {
  int n = a.size();
  for (int i = 1, j = 0; i < n; i++) {
    int bit = n >> 1;
    for (; j & bit; bit >>= 1) {
      j ^= bit;
    }
    j ^= bit;
    if (i < j) swap(a[i], a[j]);
  }
  for (int len = 2; len <= n; len <<= 1) {
    long double ang = 2 * PI / len * (invert ? -1 : 1);
    cd wlen(cosl(ang), sinl(ang));
    for (int i = 0; i < n; i += len) {
      cd w(1);
      for (int j = 0; j < len / 2; j++) {
        cd u = a[i + j], v = a[i + j + len / 2] * w;
        a[i + j] = u + v;
        a[i + j + len / 2] = u - v;
        w *= wlen;
      }
    }
  }
  if (invert) {
    for (auto& x : a) {
      x /= n;
    }
  }
}
void dft_2d(vector<vector<cd>>& a, bool invert = false) {
  int row_num = a.size();
  int col_num = a[0].size();
  int row_size = a[0].size();
  int col_size = a.size();
  for (auto& row : a) {
    dft(row, invert);
  }
  vector<cd> col(col_size);
  for (int j = 0; j < col_num; j++) {
    for (int i = 0; i < col_size; i++) {
      col[i] = a[i][j];
    }
    dft(col, invert);
    for (int i = 0; i < col_size; i++) {
      a[i][j] = col[i];
    }
  }
}
vector<vector<cd>> multiply_2var_polynomial(vector<vector<cd>> a,
                                            vector<vector<cd>> b) {
  size_t row_num = (a.size() + b.size());
  size_t temp = 1;
  for (; temp < row_num; temp <<= 1)
    ;
  row_num = temp;
  size_t col_num = a[0].size() + b[0].size();
  temp = 1;
  for (; temp < col_num; temp <<= 1)
    ;
  col_num = temp;
  a.resize(row_num);
  b.resize(row_num);
  for (int i = 0; i < row_num; i++) a[i].resize(col_num, 0);
  for (int i = 0; i < row_num; i++) b[i].resize(col_num, 0);
  vector<vector<cd>> ans(row_num, vector<cd>(col_num));
  dft_2d(a, false);
  dft_2d(b, false);
  for (int i = 0; i < row_num; i++) {
    for (int j = 0; j < col_num; j++) ans[i][j] = a[i][j] * b[i][j];
  }
  dft_2d(ans, true);
  return ans;
}
void solve() {
  int n, m;
  cin >> n >> m;
  vector<string> Big(n);
  for (int i = 0; i < n; i++) {
    cin >> Big[i];
  }
  int r, c;
  cin >> r >> c;
  vector<string> Small(r);
  for (int i = 0; i < r; i++) {
    cin >> Small[i];
  }
  int new_n = n + r;
  int new_m = m + c;
  vector<vector<cd>> big(new_n, vector<cd>(new_m, 0));
  vector<vector<cd>> small(r, vector<cd>(c));
  for (int i = 0; i < new_n; i++) {
    for (int j = 0; j < new_m; j++) {
      ld ang = 2 * PI * (Big[i % n][j % m] - 'a') / 26;
      big[i][j] = cd(cosl(ang), sinl(ang));
    }
  }
  int qcnt = 0;
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      if (Small[i][j] != '?') {
        ld ang = 2 * PI * (Small[i][j] - 'a') / 26;
        small[r - i - 1][c - j - 1] = cd(cosl(ang), -sinl(ang));
      } else {
        qcnt++;
        small[r - i - 1][c - j - 1] = 0;
      }
    }
  }
  auto temp = multiply_2var_polynomial(big, small);
  vector<vector<bool>> ans(n, vector<bool>(m, false));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      int u = r - 1 + i;
      int v = c - 1 + j;
      ld cnt = temp[u][v].real();
      if (abs(cnt - (r * c - qcnt)) < EPS) {
        ans[i][j] = true;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (ans[i][j])
        cout << 1;
      else
        cout << 0;
    }
    cout << "\n";
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  solve();
}
