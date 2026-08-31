#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9 + 7;
template <class T>
void dbs(string str, T t) {
  cerr << str << " : " << t << "\n";
}
template <class T, class... second>
void dbs(string str, T t, second... s) {
  int idx = str.find(',');
  cerr << str.substr(0, idx) << " : " << t << ",";
  dbs(str.substr(idx + 1), s...);
}
template <class second, class T>
ostream& operator<<(ostream& os, const pair<second, T>& p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <class T>
void prc(T a, T b) {
  cerr << "[";
  for (T i = a; i != b; ++i) {
    if (i != a) cerr << ", ";
    cerr << *i;
  }
  cerr << "]\n";
}
const double PI = 3.141592653589793238462643383279L;
void fft_main(int n, double theta, complex<double> a[]) {
  for (int m = n; m >= 2; m >>= 1) {
    int mh = m >> 1;
    complex<double> thetaI = complex<double>(0, theta);
    for (int i = 0; i < mh; ++i) {
      complex<double> w = exp((double)i * thetaI);
      for (int j = i; j < n; j += m) {
        int k = j + mh;
        complex<double> x = a[j] - a[k];
        a[j] += a[k];
        a[k] = w * x;
      }
    }
    theta *= 2;
  }
  int i = 0;
  for (int j = 1; j < n - 1; ++j) {
    for (int k = n >> 1; k > (i ^= k); k >>= 1)
      ;
    if (j < i) swap(a[i], a[j]);
  }
}
void fft(int n, complex<double> a[], bool rev) {
  if (rev) {
    fft_main(n, -2 * PI / n, a);
    for (int i = 0; i < n; ++i) a[i] /= n;
  } else
    fft_main(n, 2 * PI / n, a);
}
void fft2(vector<vector<complex<double>>>& a, bool rev) {
  int n = a.size();
  int m = a[0].size();
  for (int i = 0; i < n; ++i) {
    fft(m, &a[i][0], rev);
  }
  for (int i = 0; i < m; ++i) {
    vector<complex<double>> t;
    for (int j = 0; j < n; ++j) t.push_back(a[j][i]);
    fft(n, &t[0], rev);
    for (int j = 0; j < n; ++j) a[j][i] = t[j];
  }
}
void convolution(vector<vector<complex<double>>>& v,
                 vector<vector<complex<double>>>& w) {
  int n = 1, vwn = v.size() + w.size() - 1;
  while (n < vwn) n <<= 1;
  v.resize(n), w.resize(n);
  int m = 1, vwm = v[0].size() + w[0].size() - 1;
  while (m < vwm) m <<= 1;
  for (auto& it : v) it.resize(m);
  for (auto& it : w) it.resize(m);
  fft2(v, 0);
  fft2(w, 0);
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j) v[i][j] *= w[i][j];
  fft2(v, 1);
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  vector<string> a(n);
  for (auto& it : a) cin >> it;
  int r, c;
  cin >> r >> c;
  int no = r * c;
  vector<string> b(r);
  for (auto& it : b) cin >> it, no -= count(it.begin(), it.end(), '?');
  a.resize(n + r);
  for (auto& it : a) it.resize(m + c);
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      for (int I = i; I < n + r; I += n) {
        for (int J = j; J < m + c; J += m) {
          a[I][J] = a[i][j];
        }
      }
    }
  }
  vector<vector<complex<double>>> A(n + r, vector<complex<double>>(m + c));
  for (int i = 0; i < n + r; ++i) {
    for (int j = 0; j < m + c; ++j) {
      double angle = 2 * PI * (a[i][j] - 'a') / 26;
      A[i][j] = complex<double>(cos(angle), sin(angle));
    }
  }
  vector<vector<complex<double>>> B(r, vector<complex<double>>(c));
  for (int i = 0; i < r; ++i) {
    for (int j = 0; j < c; ++j) {
      if (b[i][j] == '?') continue;
      double angle = -2 * PI * (b[i][j] - 'a') / 26;
      B[r - i - 1][c - j - 1] = complex<double>(cos(angle), sin(angle));
    }
  }
  convolution(A, B);
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      int h = A[i + r - 1][j + c - 1].real() + 1e-5;
      cout << (h == no);
    }
    cout << "\n";
  }
  return 0;
}
