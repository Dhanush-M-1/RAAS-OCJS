#include <bits/stdc++.h>
using namespace std;
using mast = vector<string>;
using cd = complex<double>;
const double PI = acos(-1);
void fft(vector<cd>& a, bool invert) {
  int n = a.size();
  if (n == 1) return;
  vector<cd> a0(n / 2), a1(n / 2);
  for (int i = 0; 2 * i < n; i++) {
    a0[i] = a[2 * i];
    a1[i] = a[2 * i + 1];
  }
  fft(a0, invert);
  fft(a1, invert);
  double ang = 2 * PI / n * (invert ? -1 : 1);
  cd w(1), wn(cos(ang), sin(ang));
  for (int i = 0; 2 * i < n; i++) {
    a[i] = a0[i] + w * a1[i];
    a[i + n / 2] = a0[i] - w * a1[i];
    if (invert) {
      a[i] /= 2;
      a[i + n / 2] /= 2;
    }
    w *= wn;
  }
}
vector<cd> multiply(vector<cd> const& a, vector<cd> const& b) {
  vector<cd> fa(a.begin(), a.end()), fb(b.begin(), b.end());
  int n = 1;
  while (n < a.size() + b.size()) n <<= 1;
  fa.resize(n);
  fb.resize(n);
  fft(fa, false);
  fft(fb, false);
  for (int i = 0; i < n; i++) fa[i] *= fb[i];
  fft(fa, true);
  vector<cd> result(n);
  for (int i = 0; i < n; i++) result[i] = fa[i];
  return result;
}
int main() {
  ios_base::sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  mast st(n);
  for (int i = 0; i < n; i++) {
    cin >> st[i];
  }
  mast ss(n, "");
  int r, c;
  cin >> r >> c;
  mast pt(r);
  for (int i = 0; i < r; i++) cin >> pt[i];
  int col = ceil((c + 0.0) / m) + 1, row = ceil((r + 0.0) / n) + 1;
  for (int j = 0; j < col; j++) {
    for (int i = 0; i < n; i++) ss[i] += st[i];
  }
  for (int j = 0; j < row - 1; j++) {
    for (int i = 0; i < n; i++) ss.push_back(ss[i]);
  }
  vector<cd> s(row * col * n * m, (0, 0)), p(col * m * (r - 1) + c);
  for (int i = 0; i < row * n; i++) {
    for (int j = 0; j < col * m; j++) {
      double ang = (2 * PI * (double)(ss[i][j] - 'a')) / 26;
      s[i * m * col + j] = cd(cos(ang), sin(ang));
    }
  }
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      if (pt[i][j] == '?') {
        p[col * m * (r - i - 1) + c - j - 1] = 0;
        continue;
      }
      double ang = (2 * PI * (double)(pt[i][j] - 'a')) / 26;
      p[col * m * (r - i - 1) + c - j - 1] = cd(cos(ang), -sin(ang));
    }
  }
  auto result = multiply(s, p);
  int ct = 0;
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      ct += (pt[i][j] == '?');
    }
  }
  int ans[n][m];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      ans[i][j] = 0;
      if (abs(result[col * m * i + j + m * col * (r - 1) + c - 1].real() -
              r * c + ct) < 0.00001)
        ans[i][j] = 1;
    }
  }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++) cout << ans[i][j] << ((j == m - 1) ? "\n" : "");
}
