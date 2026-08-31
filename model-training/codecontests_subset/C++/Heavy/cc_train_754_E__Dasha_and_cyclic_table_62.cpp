#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1);
struct FFT {
  int N;
  vector<int> perm;
  void precalculate() {
    perm.resize(N);
    perm[0] = 0;
    for (int k = 1; k < N; k <<= 1) {
      for (int i = 0; i < k; i++) {
        perm[i] <<= 1;
        perm[i + k] = 1 + perm[i];
      }
    }
  }
  void fft(vector<complex<double> > &v, bool invert = false) {
    if (v.size() != perm.size()) {
      N = v.size();
      assert(N && (N & (N - 1)) == 0);
      precalculate();
    }
    for (int i = 0; i < N; i++)
      if (i < perm[i]) swap(v[i], v[perm[i]]);
    for (int len = 2; len <= N; len <<= 1) {
      double angle = 2 * PI / len;
      if (invert) angle = -angle;
      complex<double> factor = polar(1.0, angle);
      for (int i = 0; i < N; i += len) {
        complex<double> w(1);
        for (int j = 0; j < len / 2; j++) {
          complex<double> x = v[i + j], y = w * v[i + j + len / 2];
          v[i + j] = x + y;
          v[i + j + len / 2] = x - y;
          w *= factor;
        }
      }
    }
    if (invert)
      for (complex<double> &x : v) x /= N;
  }
  vector<complex<double> > multiply(vector<complex<double> > fa,
                                    vector<complex<double> > fb) {
    int n = 1;
    while (n < fa.size() + fb.size()) n <<= 1;
    fa.resize(n);
    fb.resize(n);
    fft(fa);
    fft(fb);
    for (int i = 0; i < n; i++) fa[i] *= fb[i];
    fft(fa, true);
    return fa;
  }
};
int main() {
  int n, m;
  cin >> n >> m;
  vector<string> s(n);
  for (int i = 0; i < n; i++) cin >> s[i];
  int r, c;
  cin >> r >> c;
  vector<string> t(r);
  for (int i = 0; i < r; i++) cin >> t[i];
  string ss;
  for (int i = 0; i < n; i++) {
    string add = s[i];
    add += s[i];
    while (add.size() < 2 * c) add += s[i];
    ss += add;
  }
  string base = ss;
  ss += base;
  int lines = 2 * n;
  while (lines < 2 * r) ss += base, lines += n;
  int len = ss.size() / lines;
  string tt;
  for (int i = 0; i < r; i++) {
    string add = t[i];
    while (add.size() < len) add += "?";
    tt += add;
  }
  for (int i = r; i < lines; i++) tt += string(len, '?');
  int nn = ss.size();
  vector<complex<double> > a(nn), b(nn);
  for (int i = 0; i < nn; i++) {
    if (ss[i] == '?')
      a[i] = complex<double>(0);
    else
      a[i] = polar(1.0, (ss[i] - 'a') * PI / 13);
  }
  for (int i = 0; i < nn; i++) {
    if (tt[i] == '?')
      b[i] = complex<double>(0);
    else
      b[i] = polar(1.0, -(tt[i] - 'a') * PI / 13);
  }
  reverse(b.begin(), b.end());
  FFT fft;
  vector<complex<double> > mul = fft.multiply(a, b);
  int cnt = 0;
  for (int i = 0; i < r; i++)
    for (int j = 0; j < c; j++)
      if (t[i][j] != '?') cnt++;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      int pos = i * len + j + nn - 1;
      cout << (abs(mul[pos].real() - cnt) < 1e-3);
    }
    cout << "\n";
  }
}
