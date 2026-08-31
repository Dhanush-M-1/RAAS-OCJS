#include <bits/stdc++.h>
using namespace std;
const double PI = 2 * acos(0.0);
template <class T>
void show(T a) {
  for (auto x : a) cout << x << " ";
  cout << endl;
}
const string DIGITS = "0123456789";
const int LOG = 21;
const int N = 1 << LOG;
complex<double> w[N];
int rev[N];
inline void init_fft() {
  double ang = 2.0 * PI / N;
  w[1] = complex<double>(cos(ang), sin(ang));
  w[0] = 1;
  for (int i = 2; i < N; ++i) w[i] = w[1] * w[i - 1];
  int rmask = 0;
  for (int i = 0;; ++i) {
    rev[i] = rmask;
    if (i == N - 1) break;
    for (int i = LOG - 1;; --i) {
      rmask ^= 1 << i;
      if ((rmask >> i) & 1) break;
    }
  }
}
inline void fft(vector<complex<double> > &a, int lgn) {
  int n = 1 << lgn;
  for (int i = 0; i < n; ++i) {
    int rv = rev[i] >> LOG - lgn;
    if (rv < i) swap(a[rv], a[i]);
  }
  for (int pw = 1; pw <= lgn; ++pw) {
    int len2 = 1 << pw - 1;
    int len = len2 << 1;
    for (int st = 0; st < n; st += len) {
      for (int i = 0; i < len2; ++i) {
        complex<double> u = a[st + i], v = a[st + i + len2] * w[i << LOG - pw];
        a[st + i] = u + v;
        a[st + i + len2] = u - v;
      }
    }
  }
}
inline void inverse_fft(vector<complex<double> > &a, int lgn) {
  fft(a, lgn);
  int n = 1 << lgn;
  for (auto &x : a) x /= n;
  reverse(a.begin() + 1, a.end());
}
inline vector<int> multiply(const vector<int> &a, const vector<int> &b) {
  int lgn = 0;
  int n = max(a.size(), b.size());
  while ((1 << lgn) < n) ++lgn;
  ++lgn;
  n = 1 << lgn;
  assert(lgn <= LOG);
  vector<complex<double> > fa(a.begin(), a.end()), fb(b.begin(), b.end());
  fa.resize(n, complex<double>(0, 0));
  fb.resize(n, complex<double>(0, 0));
  fft(fa, lgn);
  fft(fb, lgn);
  for (int i = 0; i < n; ++i) fa[i] *= fb[i];
  inverse_fft(fa, lgn);
  vector<int> ret(n);
  for (int i = 0; i < ((int)(fa.size())); ++i)
    ret[i] = (fa[i].real() > 0) ? fa[i].real() + 0.5 : fa[i].real() - 0.5;
  return ret;
}
inline int get(vector<vector<int> > &prec, int i, int j, int ii, int jj) {
  if (!i && !j) {
    return prec[ii][jj];
  } else if (!i) {
    j--;
    return prec[ii][jj] - prec[ii][j];
  } else if (!j) {
    i--;
    return prec[ii][jj] - prec[i][jj];
  } else {
    i--;
    j--;
    return prec[ii][jj] - prec[i][jj] - prec[ii][j] + prec[i][j];
  }
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  init_fft();
  int n, m;
  cin >> n >> m;
  int init_n = n, init_m = m;
  vector<vector<int> > tmp(n, vector<int>(m));
  for (int i = 0; i < int(n); ++i) {
    string s;
    cin >> s;
    for (int j = 0; j < int(m); ++j) {
      tmp[i][j] = s[j] - 'a' + 1;
    }
  }
  int r, c;
  cin >> r >> c;
  n = n + r + 1;
  m = m + c + 1;
  vector<int> pattern(n * m, 0);
  for (int i = 0; i < int(r); ++i) {
    string s;
    cin >> s;
    for (int j = 0; j < int(c); ++j) {
      int cur = s[j] - 'a' + 1;
      if (s[j] == '?') cur = 0;
      pattern[i * m + j] = cur;
    }
  }
  r = n, c = m;
  reverse(pattern.begin(), pattern.end());
  vector<int> str(n * m);
  for (int i = 0; i < int(n); ++i)
    for (int j = 0; j < int(m); ++j) {
      str[i * m + j] = tmp[i % init_n][j % init_m];
    }
  vector<int> pat_sqr(r * c);
  for (int i = 0; i < int(((int)(pat_sqr.size()))); ++i)
    pat_sqr[i] = (pattern[i]) * (pattern[i]);
  int sum_three = 0;
  for (int i = 0; i < int(r * c); ++i) sum_three += pat_sqr[i] * pattern[i];
  vector<int> str_sqr(n * m, 0);
  for (int i = 0; i < n * m; ++i) {
    str_sqr[i] = (str[i]) * (str[i]);
  }
  vector<int> f1 = multiply(str, pat_sqr);
  vector<int> f2 = multiply(str_sqr, pattern);
  for (int i = 0; i < int(init_n); ++i) {
    string s(init_m, ' ');
    for (int j = 0; j < int(init_m); ++j) {
      int cur =
          sum_three - 2 * f1[i * m + j + r * c - 1] + f2[i * m + j + r * c - 1];
      s[j] = char(!bool(cur) + '0');
    }
    cout << s << "\n";
  }
}
