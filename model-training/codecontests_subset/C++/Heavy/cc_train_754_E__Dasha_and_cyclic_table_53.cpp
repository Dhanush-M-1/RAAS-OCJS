#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
void fft(valarray<complex<double> > &x) {
  unsigned int N = x.size(), k = N, n;
  double thetaT = 3.14159265358979323846264338328L / N;
  complex<double> phiT = complex<double>(cos(thetaT), sin(thetaT)), T;
  while (k > 1) {
    n = k;
    k >>= 1;
    phiT = phiT * phiT;
    T = 1.0L;
    for (unsigned int l = 0; l < k; l++) {
      for (unsigned int a = l; a < N; a += n) {
        unsigned int b = a + k;
        complex<double> t = x[a] - x[b];
        x[a] += x[b];
        x[b] = t * T;
      }
      T *= phiT;
    }
  }
  unsigned int m = (unsigned int)log2(N);
  for (unsigned int a = 0; a < N; a++) {
    unsigned int b = a;
    b = (((b & 0xaaaaaaaa) >> 1) | ((b & 0x55555555) << 1));
    b = (((b & 0xcccccccc) >> 2) | ((b & 0x33333333) << 2));
    b = (((b & 0xf0f0f0f0) >> 4) | ((b & 0x0f0f0f0f) << 4));
    b = (((b & 0xff00ff00) >> 8) | ((b & 0x00ff00ff) << 8));
    b = ((b >> 16) | (b << 16)) >> (32 - m);
    if (b > a) {
      complex<double> t = x[a];
      x[a] = x[b];
      x[b] = t;
    }
  }
}
void ifft(valarray<complex<double> > &x) {
  x = x.apply(conj);
  fft(x);
  x = x.apply(conj);
  x /= x.size();
}
void fft2d(vector<valarray<complex<double> > > &X) {
  for (int i = 0; i < X.size(); i++) fft(X[i]);
  for (int i = 0; i < X[0].size(); i++) {
    valarray<complex<double> > tmp(X.size());
    for (int j = 0; j < X.size(); j++) tmp[j] = X[j][i];
    fft(tmp);
    for (int j = 0; j < X.size(); j++) X[j][i] = tmp[j];
  }
}
void ifft2d(vector<valarray<complex<double> > > &X) {
  for (int i = 0; i < X.size(); i++) ifft(X[i]);
  for (int i = 0; i < X[0].size(); i++) {
    valarray<complex<double> > tmp(X.size());
    for (int j = 0; j < X.size(); j++) tmp[j] = X[j][i];
    ifft(tmp);
    for (int j = 0; j < X.size(); j++) X[j][i] = tmp[j];
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  string a[801];
  for (int i = 0; i < n; i++) cin >> a[i];
  int r, c;
  cin >> r >> c;
  string b[401];
  for (int i = 0; i < r; i++) cin >> b[i];
  for (int i = 0; i < n; i++)
    for (int j = 0; j < c - 1; j++) a[i] += a[i][j];
  for (int i = 0; i < r - 1; i++) a[i + n] = a[i];
  int nn = n + r - 1, mm = m + c - 1, b2n = 1, b2m = 1;
  while (b2n <= max(nn, r)) b2n <<= 1;
  while (b2m <= max(mm, c)) b2m <<= 1;
  vector<valarray<complex<double> > > A(b2n, valarray<complex<double> >(b2m));
  for (int i = 0; i < nn; i++)
    for (int j = 0; j < mm; j++) {
      double ang = 2.0 * PI * (a[i][j] - 'a') / 26.0;
      A[i][j] = complex<double>(cos(ang), sin(ang));
    }
  fft2d(A);
  int q = 0;
  vector<valarray<complex<double> > > B(b2n, valarray<complex<double> >(b2m));
  for (int i = 0; i < r; i++)
    for (int j = 0; j < c; j++)
      if (b[i][j] != '?') {
        double ang = -2.0 * PI * (b[i][j] - 'a') / 26.0;
        B[r - i - 1][c - j - 1] = complex<double>(cos(ang), sin(ang));
        q++;
      }
  fft2d(B);
  for (int i = 0; i < A.size(); i++)
    for (int j = 0; j < A[i].size(); j++) A[i][j] *= B[i][j];
  ifft2d(A);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++)
      if (floor(A[i + r - 1][j + c - 1].real() + 0.0000001) == q)
        cout << "1";
      else
        cout << "0";
    cout << endl;
  }
  return 0;
}
