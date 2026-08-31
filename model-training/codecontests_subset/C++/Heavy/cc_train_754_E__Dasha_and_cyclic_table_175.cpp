#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
bool bit(int mask, int i) { return (mask >> i) & 1; }
struct cd {
  double x, y;
  cd() : x(0), y(0) {}
  cd(double x, double y) : x(x), y(y) {}
  cd(double z) : x(z), y(0) {}
  cd& operator*=(const cd& z) {
    tie(x, y) = make_pair(x * z.x - y * z.y, x * z.y + y * z.x);
    return *this;
  }
  cd operator*(const cd& z) const {
    cd tmp = z;
    tmp *= *this;
    return tmp;
  }
  cd& operator/=(const double& z) {
    x /= z;
    y /= z;
    return *this;
  }
  cd& operator+=(const cd& z) {
    x += z.x;
    y += z.y;
    return *this;
  }
  cd operator+(const cd& z) const {
    cd tmp = z;
    tmp += *this;
    return tmp;
  }
  cd operator-(const cd& z) const { return cd(x - z.x, y - z.y); }
  double real() const { return x; }
  double imag() const { return y; }
};
cd conj(const cd& z) { return cd(z.real(), -z.imag()); }
namespace FFT {
const int B = 12;
const int N = 1 << B;
cd roots[N];
int inv[N];
cd get_root(int k, int n) { return roots[k * (N / n)]; }
void precalc() {
  for (int i = 0; i < int(N); ++i) {
    double ang = 2 * PI * i / N;
    roots[i] = cd(cos(ang), sin(ang));
  }
}
void precalc_inv(int n) {
  int b = 0;
  while ((1 << b) < n) ++b;
  assert((1 << b) == n);
  assert(b <= B);
  inv[0] = 0;
  int hb = -1;
  for (int i = 1; i < n; ++i) {
    if (bit(i, hb + 1)) {
      ++hb;
    }
    inv[i] = inv[i ^ (1 << hb)] ^ (1 << (b - hb - 1));
  }
}
void fft(vector<cd>& a, bool rev) {
  precalc_inv(((int)(a).size()));
  for (int i = 0; i < int(((int)(a).size())); ++i) {
    if (i < inv[i]) {
      swap(a[i], a[inv[i]]);
    }
  }
  for (int len = 1; len * 2 <= ((int)(a).size()); len *= 2) {
    for (int i = 0; i < ((int)(a).size()); i += len * 2) {
      for (int j = 0; j < int(len); ++j) {
        cd x = a[i + j];
        cd y = a[i + len + j];
        cd r = get_root(j, len * 2);
        if (rev) {
          r = conj(r);
        }
        a[i + j] = x + r * y;
        a[i + len + j] = x - r * y;
        if (rev) {
          a[i + j] /= 2;
          a[i + len + j] /= 2;
        }
      }
    }
  }
}
void fft_2d(vector<vector<cd>>& a, bool rev) {
  for (auto& row : a) {
    fft(row, rev);
  }
  for (int j = 0; j < int(((int)(a.front()).size())); ++j) {
    vector<cd> col;
    for (int i = 0; i < int(((int)(a).size())); ++i) {
      col.push_back(a[i][j]);
    }
    fft(col, rev);
    for (int i = 0; i < int(((int)(a).size())); ++i) {
      a[i][j] = col[i];
    }
  }
}
vector<vector<cd>> mult(vector<vector<cd>> x, vector<vector<cd>> y) {
  int b_rows = 0;
  while ((1 << b_rows) <= max(((int)(x).size()), ((int)(y).size()))) ++b_rows;
  ++b_rows;
  int b_cols = 0;
  while ((1 << b_cols) <=
         max(((int)(x.front()).size()), ((int)(y.front()).size())))
    ++b_cols;
  ++b_cols;
  x.resize(1 << b_rows);
  y.resize(1 << b_rows);
  for (auto& row : x) {
    row.resize(1 << b_cols, 0);
  }
  for (auto& row : y) {
    row.resize(1 << b_cols, 0);
  }
  fft_2d(x, 0);
  fft_2d(y, 0);
  for (int i = 0; i < int(((int)(x).size())); ++i)
    for (int j = 0; j < int(((int)(x[i]).size())); ++j) {
      x[i][j] *= y[i][j];
    }
  fft_2d(x, 1);
  return x;
}
vector<vector<cd>> brut_mult(vector<vector<cd>> x, vector<vector<cd>> y) {
  vector<vector<cd>> res(((int)(x).size()) + ((int)(y).size()));
  for (int i = 0; i < int(((int)(res).size())); ++i) {
    res[i].resize(((int)(x.front()).size()) + ((int)(y.front()).size()));
  }
  for (int i = 0; i < int(((int)(x).size())); ++i)
    for (int j = 0; j < int(((int)(x[i]).size())); ++j)
      for (int ii = 0; ii < int(((int)(y).size())); ++ii)
        for (int jj = 0; jj < int(((int)(y[ii]).size())); ++jj) {
          res.at(i + ii).at(j + jj) += x[i][j] * y[ii][jj];
        }
  return res;
}
};  // namespace FFT
const int MAXN = 800 + 10;
const int AL = 26;
int n, m;
char a[MAXN][MAXN];
int r, c;
char b[MAXN][MAXN];
bool read() {
  if (scanf("%d%d\n", &n, &m) < 2) {
    return 0;
  }
  for (int i = 0; i < int(n); ++i) {
    scanf("%s\n", a[i]);
    for (int j = m; j < MAXN; ++j) {
      a[i][j] = 0;
    }
  }
  scanf("%d%d\n", &r, &c);
  for (int i = 0; i < int(r); ++i) {
    scanf("%s\n", b[i]);
  }
  return 1;
}
int new_n, new_m;
void expand() {
  new_n = new_m = 0;
  for (int i = 0; i < int(n); ++i) {
    for (int j = 0; j < int(m); ++j) {
      for (int ii = i; ii < n + r; ii += n) {
        for (int jj = j; jj < m + c; jj += m) {
          a[ii][jj] = a[i][j];
          new_n = max(new_n, ii + 1);
          new_m = max(new_m, jj + 1);
        }
      }
    }
  }
}
void solve() {
  expand();
  vector<vector<cd>> A(new_n, vector<cd>(new_m, 0));
  for (int i = 0; i < int(new_n); ++i)
    for (int j = 0; j < int(new_m); ++j) {
      int ch = a[i][j] - 'a';
      double ang = 2 * PI * ch / AL;
      A[i][j] = cd(cos(ang), sin(ang));
    }
  int not_questions = 0;
  vector<vector<cd>> B(r, vector<cd>(c, 0));
  for (int i = 0; i < int(r); ++i)
    for (int j = 0; j < int(c); ++j) {
      if (b[i][j] == '?') {
        continue;
      }
      ++not_questions;
      int ch = b[i][j] - 'a';
      double ang = -2 * PI * ch / AL;
      B[r - i - 1][c - j - 1] = cd(cos(ang), sin(ang));
    }
  auto C = FFT::mult(A, B);
  for (int i = 0; i < int(n); ++i) {
    for (int j = 0; j < int(m); ++j) {
      bool can = 0;
      int cnt = floor(C[i + r - 1][j + c - 1].real() + 1e-5);
      assert(cnt <= not_questions);
      if (cnt == not_questions) {
        can = 1;
      }
      printf("%d", can);
    }
    puts("");
  }
}
int main() {
  FFT::precalc();
  while (read()) {
    solve();
  }
  return 0;
}
