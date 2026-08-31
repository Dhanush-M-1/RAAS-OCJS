#include <bits/stdc++.h>
using namespace std;
const long double PI = acos((long double)-1);
namespace fft {
template <class T>
class comp {
 public:
  T real, img;
  comp(T a = (T)0, T b = (T)0) : real(a), img(b) {}
  comp conj() { return comp(this->real, -(this->img)); }
  comp operator=(const comp& a) {
    this->real = a.real, this->img = a.img;
    return *this;
  }
  comp operator+(const comp& b) {
    return comp(this->real + b.real, this->img + b.img);
  }
  comp operator-(const comp& b) {
    return comp(this->real - b.real, this->img - b.img);
  }
  comp operator*(const T& num) {
    return comp(this->real * num, this->img * num);
  }
  comp operator/(const T& num) {
    return comp(this->real / num, this->img / num);
  }
  comp operator*(const comp& b) {
    return comp(this->real * b.real - this->img * b.img,
                this->img * b.real + this->real * b.img);
  }
  comp operator/(const comp& b) {
    comp temp(b.real, -b.img);
    comp n = (*this) * temp;
    return n / (b.x * b.x + b.y * b.y);
  }
};
comp<long double> w[1 << 20];
int rev[1 << 20];
void revbits(int newlim) {
  static int lim = -1;
  int t, j;
  if (newlim == lim) return;
  lim = newlim;
  int k = 0;
  while ((1 << k) < newlim) ++k;
  assert((1 << k) == newlim);
  for (int i = 1; i <= (int)(lim); ++i) {
    j = rev[i - 1];
    t = k - 1;
    while (t >= 0 && ((j >> t) & 1)) j ^= (1 << t), --t;
    if (t >= 0) j ^= (1 << t), --t;
    rev[i] = j;
  }
}
void fft(vector<comp<long double> >& poly, int inv = false) {
  int len, l;
  revbits((int)(poly).size());
  for (int i = 0; i < (int)((int)(poly).size()); ++i)
    if (rev[i] > i) swap(poly[i], poly[rev[i]]);
  comp<long double> u, v;
  for (len = 2, l = 1; len <= (int)(poly).size(); len += len, l += l) {
    if (w[l].real == 0 && w[l].img == 0) {
      long double ang = PI / l;
      comp<long double> ww(cos(ang), sin(ang));
      if (l > 1) {
        for (int j = 0; j < l; ++j) {
          if (j & 1)
            w[l + j] = w[(l + j) >> 1] * ww;
          else
            w[l + j] = w[(l + j) >> 1];
        }
      } else
        w[l] = comp<long double>(1.0, 0.0);
    }
    for (int i = 0; i < (int)(poly).size(); i += len)
      for (int j = 0; j < (int)(l); ++j) {
        u = poly[i + j],
        v = poly[i + j + l] * (inv ? w[l + j].conj() : w[l + j]);
        poly[i + j] = u + v, poly[i + j + l] = u - v;
      }
  }
  if (inv)
    for (auto& x : poly) x = x / (long double)(int)(poly).size();
}
void fft2d(vector<vector<comp<long double> > >& A, bool inv = false) {
  for (auto& row : A) {
    fft(row, inv);
  }
  vector<comp<long double> > col((int)(A).size());
  for (int j = 0; j < (int)((int)(A.front()).size()); ++j) {
    for (int i = 0; i < (int)((int)(A).size()); ++i) col[i] = A[i][j];
    fft(col, inv);
    for (int i = 0; i < (int)((int)(A).size()); ++i) A[i][j] = col[i];
  }
}
vector<vector<comp<long double> > > multiply(
    vector<vector<comp<long double> > >& x,
    vector<vector<comp<long double> > >& y) {
  int b_rows = 0, b_cols = 0;
  while ((1 << b_rows) <= max((int)(x).size(), (int)(y).size())) ++b_rows;
  ++b_rows;
  while ((1 << b_cols) <= max((int)(x.front()).size(), (int)(y.front()).size()))
    ++b_cols;
  ++b_cols;
  x.resize(1 << b_rows);
  y.resize(1 << b_rows);
  for (auto& row : x) row.resize(1 << b_cols, 0);
  for (auto& row : y) row.resize(1 << b_cols, 0);
  fft2d(x), fft2d(y);
  for (int i = 0; i < (int)((int)(x).size()); ++i)
    for (int j = 0; j < (int)((int)(x[i]).size()); ++j)
      x[i][j] = x[i][j] * y[i][j];
  fft2d(x, 1);
  return x;
}
const int L = 805;
string A[L], B[L];
int N, M, R, C, X, Y;
void read() {
  cin >> N >> M;
  for (int i = 0; i < (int)(N); ++i) cin >> A[i];
  cin >> R >> C;
  for (int i = 0; i < (int)(R); ++i) cin >> B[i];
}
void solve() {
  X = N + R, Y = M + C;
  vector<vector<comp<long double> > > a(X, vector<comp<long double> >(Y));
  for (int i = 0; i < (int)(N); ++i)
    for (int j = 0; j < (int)(M); ++j) {
      a[i][j].real = cos(2 * PI * (A[i][j] - 'a') / 26.0),
      a[i][j].img = sin(2 * PI * (A[i][j] - 'a') / 26.0);
      for (int ii = i; ii < X; ii += N)
        for (int jj = j; jj < Y; jj += M) a[ii][jj] = a[i][j];
    }
  vector<vector<comp<long double> > > b(R, vector<comp<long double> >(C));
  int valid = 0;
  for (int i = 0; i < (int)(R); ++i)
    for (int j = 0; j < (int)(C); ++j) {
      if (B[i][j] == '?') continue;
      ++valid;
      b[R - i - 1][C - j - 1].real = cos(2 * PI * (B[i][j] - 'a') / 26.0),
                           b[R - i - 1][C - j - 1].img =
                               -sin(2 * PI * (B[i][j] - 'a') / 26.0);
    }
  vector<vector<comp<long double> > > c = multiply(a, b);
  for (int i = 0; i < (int)(N); ++i) {
    for (int j = 0; j < (int)(M); ++j)
      cout << ((int)(c[R - 1 + i][C - 1 + j].real + 1e-5) == valid);
    cout << "\n";
  }
}
}  // namespace fft
int main() {
  std::ios::sync_with_stdio(false);
  fft::read();
  fft::solve();
  return 0;
}
