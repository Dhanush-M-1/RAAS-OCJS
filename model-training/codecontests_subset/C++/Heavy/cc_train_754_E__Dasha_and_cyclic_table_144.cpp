#include <bits/stdc++.h>
using namespace std;
static const int INF = 0x3f3f3f3f;
static const long long INFL = 0x3f3f3f3f3f3f3f3fLL;
template <typename T, typename U>
static void amin(T &x, U y) {
  if (y < x) x = y;
}
template <typename T, typename U>
static void amax(T &x, U y) {
  if (x < y) x = y;
}
const double PI = 3.141592653589793238462643383279L;
void fft_core(complex<double> *x, int logn, int sign) {
  int n = 1 << logn;
  for (int i = 1, j = 0; i < n; ++i) {
    int h = n >> 1;
    while (((j ^= h) & h) == 0) h >>= 1;
    if (i < j) swap(x[i], x[j]);
  }
  for (int m = 2; m <= n; m <<= 1) {
    int h = m >> 1;
    double theta = sign * 2 * PI / m;
    double pr = cos(theta), pi = sin(theta);
    for (int i = 0; i < n; i += m) {
      double wr = 1, wi = 0;
      for (int j = i; j < i + h; ++j) {
        int k = j + h;
        double lr = x[k].real() * wr - x[k].imag() * wi;
        double li = x[k].real() * wi + x[k].imag() * wr;
        x[k] = complex<double>(x[j].real() - lr, x[j].imag() - li);
        x[j] = complex<double>(x[j].real() + lr, x[j].imag() + li);
        double nwr = wr * pr - wi * pi;
        double nwi = wr * pi + wi * pr;
        wr = nwr, wi = nwi;
      }
    }
  }
}
void fft(int logn, complex<double> a[]) { fft_core(a, logn, +1); }
void inverse_fft(int logn, complex<double> a[]) {
  fft_core(a, logn, -1);
  complex<double> inv = double(1) / (1 << logn);
  for (int(i) = 0; (i) < (int)(1 << logn); ++(i)) a[i] *= inv;
}
using Ring = complex<double>;
void FFT2D(int logh, int H, int logw, int W, vector<vector<Ring>> &A) {
  assert(A.size() == 1 << logh);
  for (int(i) = 0; (i) < (int)(H); ++(i)) {
    assert(A[i].size() == 1 << logw);
    fft(logw, A[i].data());
  }
  vector<Ring> tmp(1 << logh);
  for (int(j) = 0; (j) < (int)(1 << logw); ++(j)) {
    for (int(i) = 0; (i) < (int)(1 << logh); ++(i)) tmp[i] = A[i][j];
    fft(logh, tmp.data());
    for (int(i) = 0; (i) < (int)(1 << logh); ++(i)) A[i][j] = tmp[i];
  }
}
void FFT2Dinv(int logh, int H, int logw, int W, vector<vector<Ring>> &A) {
  vector<Ring> tmp(1 << logh);
  for (int(j) = 0; (j) < (int)(1 << logw); ++(j)) {
    for (int(i) = 0; (i) < (int)(1 << logh); ++(i)) tmp[i] = A[i][j];
    inverse_fft(logh, tmp.data());
    for (int(i) = 0; (i) < (int)(1 << logh); ++(i)) A[i][j] = tmp[i];
  }
  for (int(i) = 0; (i) < (int)(H); ++(i)) inverse_fft(logw, A[i].data());
}
int main() {
  int tH;
  int tW;
  while (~scanf("%d%d", &tH, &tW)) {
    vector<string> table(tH);
    for (int(i) = 0; (i) < (int)(tH); ++(i)) {
      char buf[401];
      scanf("%s", buf);
      table[i] = buf;
    }
    int pH;
    int pW;
    scanf("%d%d", &pH, &pW);
    vector<string> pattern(pH);
    for (int(i) = 0; (i) < (int)(pH); ++(i)) {
      char buf[401];
      scanf("%s", buf);
      pattern[i] = buf;
    }
    int H = tH + pH, W = tW + pW;
    int logh = 1, logw = 1;
    while (1 << logh < H) ++logh;
    while (1 << logw < W) ++logw;
    vector<vector<Ring>> A(1 << logh, vector<Ring>(1 << logw)), B = A;
    for (int(i) = 0; (i) < (int)(tH + pH); ++(i))
      for (int(j) = 0; (j) < (int)(tW + pW); ++(j)) {
        char c = table[i % tH][j % tW];
        double theta = 2 * PI * (c - 'a') / 26;
        A[tH + pH - 1 - i][tW + pW - 1 - j] = polar(double(1), theta);
      }
    for (int(i) = 0; (i) < (int)(pH); ++(i))
      for (int(j) = 0; (j) < (int)(pW); ++(j)) {
        char c = pattern[i][j];
        if (c == '?') continue;
        double theta = -2 * PI * (c - 'a') / 26;
        B[i][j] = polar(double(1), theta);
      }
    FFT2D(logh, H, logw, W, A);
    FFT2D(logh, H, logw, W, B);
    for (int(i) = 0; (i) < (int)(1 << logh); ++(i))
      for (int(j) = 0; (j) < (int)(1 << logw); ++(j)) A[i][j] *= B[i][j];
    FFT2Dinv(logh, H, logw, W, A);
    int qs = 0;
    for (int(i) = 0; (i) < (int)(pH); ++(i))
      for (int(j) = 0; (j) < (int)(pW); ++(j)) qs += pattern[i][j] == '?';
    vector<string> ans(tH, string(tW, '?'));
    for (int(i) = 0; (i) < (int)(tH); ++(i))
      for (int(j) = 0; (j) < (int)(tW); ++(j)) {
        Ring r = A[tH + pH - 1 - i][tW + pW - 1 - j];
        ans[i][j] = r.real() >= (pH * pW - qs) - 1e-6 ? '1' : '0';
      }
    for (int(i) = 0; (i) < (int)(tH); ++(i)) puts(ans[i].c_str());
  }
  return 0;
}
