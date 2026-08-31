#include <bits/stdc++.h>
using namespace std;
class cd {
  double a, b;

 public:
  cd() { a = b = 0; }
  cd(long long _a) { a = _a, b = 0; }
  cd(double _a, double _b) { a = _a, b = _b; }
  double real() { return a; }
  double imag() { return b; }
  void operator+=(cd& X) { a += X.a, b += X.b; }
  void operator*=(cd& X) {
    double _a = a, _b = b;
    a = _a * X.a - _b * X.b, b = _b * X.a + _a * X.b;
  }
  void operator/=(long long n) { a /= (double)n, b /= (double)n; }
  cd operator*(cd& X) { return cd(a * X.a - b * X.b, b * X.a + a * X.b); }
  cd operator+(cd& X) { return cd(a + X.a, b + X.b); }
  cd operator-(cd& X) { return cd(a - X.a, b - X.b); }
};
const double PI = acos(-1.0);
long long rev[3210], cur_len = 0;
cd W[3210];
void reverse(long long n) {
  for (long long i = 0; i < n; ++i) {
    rev[i] = rev[i >> 1] >> 1;
    if (i & 1) rev[i] ^= (n >> 1);
  }
}
void fft(vector<cd>& A, bool inv = 0) {
  long long n = A.size();
  if (cur_len != n) reverse(n), cur_len = n;
  for (long long i = 0; i < n; ++i) {
    if (i < rev[i]) swap(A[i], A[rev[i]]);
  }
  for (long long s = 1; s < n; s <<= 1) {
    double x = (inv ? -1 : 1) * PI / s;
    cd w(cos(x), sin(x));
    W[0] = cd(1, 0);
    for (long long i = 1; i < s; ++i) W[i] = W[i - 1] * w;
    for (long long i = 0; i < n; i += 2 * s) {
      for (long long j = 0; j < s; ++j) {
        cd u = A[i + j], v = A[i + j + s] * W[j];
        A[i + j] = u + v, A[i + j + s] = u - v;
      }
    }
  }
  if (inv)
    for (long long i = 0; i < n; ++i) A[i] /= n;
}
string s[810], t[810];
void fft2(vector<vector<cd>>& A, long long inv = 0) {
  for (auto& v : A) fft(v, inv);
  for (long long j = 0; j < (long long)(A[0]).size(); ++j) {
    vector<cd> tmp;
    for (long long i = 0; i < (long long)(A).size(); ++i)
      tmp.push_back(A[i][j]);
    fft(tmp, inv);
    for (long long i = 0; i < (long long)(A).size(); ++i) A[i][j] = tmp[i];
  }
}
void mul(vector<vector<cd>>& A, vector<vector<cd>>& B) {
  long long n = 1, m = 1;
  while (n < max((long long)(A).size(), (long long)(B).size())) n <<= 1;
  n <<= 1;
  while (m < max((long long)(A[0]).size(), (long long)(B[0]).size())) m <<= 1;
  m <<= 1;
  A.resize(n), B.resize(n);
  for (auto& v : A) v.resize(m);
  for (auto& v : B) v.resize(m);
  fft2(A), fft2(B);
  for (long long i = 0; i < n; ++i)
    for (long long j = 0; j < m; ++j) A[i][j] = A[i][j] * B[i][j];
  fft2(A, 1);
}
cd get(char c, long long y = 1) {
  double x = 2 * PI * (c - 'a') * y / 26.00;
  return cd(cos(x), sin(x));
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, m;
  cin >> n >> m;
  for (long long i = 0; i < n; ++i) cin >> s[i];
  long long r, c;
  cin >> r >> c;
  for (long long i = 0; i < r; ++i) cin >> t[i];
  for (long long i = 0; i < n; ++i)
    for (long long j = m; j < m + c; ++j) s[i] += s[i][j % m];
  for (long long i = n; i < n + r; ++i) s[i] = s[i % n];
  vector<vector<cd>> a(n + r, vector<cd>(m + c, 0));
  for (long long i = 0; i < n + r; ++i)
    for (long long j = 0; j < m + c; ++j) a[i][j] = get(s[i][j]);
  vector<vector<cd>> b(r, vector<cd>(c, 0));
  long long cnt = 0;
  for (long long i = 0; i < r; ++i)
    for (long long j = 0; j < c; ++j) {
      if (t[i][j] == '?')
        ++cnt;
      else
        b[r - i - 1][c - j - 1] = get(t[i][j], -1);
    }
  mul(a, b);
  for (long long i = 0; i < n; ++i) {
    for (long long j = 0; j < m; ++j)
      cout << ((abs((long double)a[i + r - 1][j + c - 1].real() -
                    (long double)(r * c - cnt))) < (long double)(1e-4));
    cout << "\n";
  }
  return 0;
}
