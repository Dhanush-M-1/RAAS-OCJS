#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1);
struct my_complex {
  double re, im;
};
inline my_complex operator*(const my_complex &a, const my_complex &b) {
  return {a.re * b.re - a.im * b.im, a.re * b.im + a.im * b.re};
}
inline my_complex operator+(const my_complex &a, const my_complex &b) {
  return {a.re + b.re, a.im + b.im};
}
inline my_complex operator-(const my_complex &a, const my_complex &b) {
  return {a.re - b.re, a.im - b.im};
}
void fft(vector<my_complex> &a, bool invert) {
  int n = (int)a.size(), k = (int)log2(n);
  for (int i = 0; i < n; i++) {
    int rev = 0;
    for (int j = 0; j < k; j++) {
      if (i & (1 << j)) {
        rev |= (1 << (k - j - 1));
      }
    }
    if (rev < i) {
      swap(a[i], a[rev]);
    }
  }
  for (int len = 2; len <= n; len *= 2) {
    double ang = 2 * pi / (double)len * (invert ? -1 : 1);
    my_complex w_len = {cos(ang), sin(ang)};
    for (int i = 0; i < n; i += len) {
      my_complex w = {1, 0};
      for (int j = i; j < i + len / 2; j++) {
        my_complex u = a[j], v = a[j + len / 2] * w;
        a[j] = u + v;
        a[j + len / 2] = u - v;
        w = w * w_len;
      }
    }
  }
  if (invert) {
    for (auto &x : a) {
      x.re /= n;
      x.im /= n;
    }
  }
}
void fft(vector<vector<my_complex> > &a, bool invert) {
  for (int i = 0; i < (int)a.size(); i++) {
    fft(a[i], invert);
  }
  for (int j = 0; j < (int)a[0].size(); j++) {
    vector<my_complex> tmp;
    for (int i = 0; i < (int)a.size(); i++) {
      tmp.push_back(a[i][j]);
    }
    fft(tmp, invert);
    for (int i = 0; i < (int)a.size(); i++) {
      a[i][j] = tmp[i];
    }
  }
}
vector<vector<my_complex> > mul(const vector<vector<my_complex> > &a,
                                const vector<vector<my_complex> > &b) {
  int n = 1, m = 1;
  while (n < (int)a.size() + (int)b.size()) {
    n *= 2;
  }
  while (m < (int)a[0].size() + (int)b[0].size()) {
    m *= 2;
  }
  vector<vector<my_complex> > f(n, vector<my_complex>(m)),
      g(n, vector<my_complex>(m));
  for (int i = 0; i < (int)a.size(); i++) {
    for (int j = 0; j < (int)a[i].size(); j++) {
      f[i][j] = a[i][j];
    }
  }
  for (int i = 0; i < (int)b.size(); i++) {
    for (int j = 0; j < (int)b[i].size(); j++) {
      g[i][j] = b[i][j];
    }
  }
  fft(f, false);
  fft(g, false);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      f[i][j] = f[i][j] * g[i][j];
    }
  }
  fft(f, true);
  vector<vector<my_complex> > ans(
      (int)a.size() + (int)b.size() - 1,
      vector<my_complex>((int)a[0].size() + (int)b[0].size() - 1));
  for (int i = 0; i < (int)ans.size(); i++) {
    for (int j = 0; j < (int)ans[i].size(); j++) {
      ans[i][j] = f[i][j];
    }
  }
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  vector<string> grid(2 * n);
  for (int i = 0; i < n; i++) {
    cin >> grid[i];
  }
  int r, c;
  cin >> r >> c;
  grid.resize(n + r - 1);
  for (int i = 0; i < n; i++) {
    for (int j = m; j < m + c - 1; j++) {
      grid[i] += grid[i][j - m];
    }
  }
  for (int i = n; i < n + r - 1; i++) {
    grid[i] = grid[i - n];
  }
  n += r - 1;
  m += c - 1;
  vector<string> pattern(r);
  for (int i = 0; i < r; i++) {
    cin >> pattern[i];
  }
  vector<vector<my_complex> > a(n, vector<my_complex>(m)),
      b(r, vector<my_complex>(c, {0, 0}));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      double ang = 2 * pi * (grid[i][j] - 'a') / 26;
      a[i][j] = {cos(ang), sin(ang)};
    }
  }
  int not_wildcard = 0;
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      if (pattern[i][j] == '?') {
        continue;
      }
      not_wildcard++;
      double ang = 2 * pi * (pattern[i][j] - 'a') / 26;
      b[r - i - 1][c - j - 1] = {cos(-ang), sin(-ang)};
    }
  }
  vector<vector<my_complex> > ans = mul(a, b);
  for (int i = r - 1; i < n; i++) {
    for (int j = c - 1; j < m; j++) {
      int re = (int)floor(ans[i][j].re + 1e-5);
      if (re == not_wildcard) {
        cout << 1;
      } else {
        cout << 0;
      }
    }
    cout << '\n';
  }
  return 0;
}
