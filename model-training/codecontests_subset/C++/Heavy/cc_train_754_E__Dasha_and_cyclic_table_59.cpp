#include <bits/stdc++.h>
using namespace std;
void runtime() {
  cout << fixed << setprecision(5) << 1.0 * clock() / CLOCKS_PER_SEC << endl;
}
template <class T>
void read(vector<T> &a, int n) {
  T x;
  a.clear();
  for (int i = 0; i < n; i++) {
    cin >> x;
    a.push_back(x);
  }
}
template <class T>
void write(vector<T> &a) {
  for (T x : a) cout << x << ' ';
  cout << '\n';
}
const int N = 404;
const double PI = acos(-1.0);
struct cd {
  double real, imag;
  cd(double _real = 0.0, double _imag = 0.0) : real(_real), imag(_imag) {}
};
cd operator+(const cd &a, const cd &b) {
  return cd(a.real + b.real, a.imag + b.imag);
}
cd operator-(const cd &a, const cd &b) {
  return cd(a.real - b.real, a.imag - b.imag);
}
cd operator*(const cd &a, const cd &b) {
  return cd(a.real * b.real - a.imag * b.imag,
            a.real * b.imag + a.imag * b.real);
}
cd operator/(const cd &a, const int &b) { return cd(a.real / b, a.imag / b); }
vector<cd> prec_w;
int lg;
void precomp(int need_lg) {
  if (prec_w.size() >= (1 << need_lg) + 1) return;
  lg = need_lg;
  prec_w.clear();
  cd w(1, 0);
  double ang = 2 * PI / (1 << need_lg);
  cd wlen(cos(ang), sin(ang));
  while (prec_w.size() != (1 << need_lg) + 1) {
    prec_w.push_back(w);
    w = w * wlen;
  }
}
void fft(vector<cd> &a, bool invert = 0) {
  int n = (int)a.size();
  for (int i = 1, j = 0; i < n; i++) {
    int bit = n >> 1;
    for (; j & bit; bit >>= 1) j ^= bit;
    j ^= bit;
    if (i < j) swap(a[i], a[j]);
  }
  for (int cur_lg = 1; (1 << cur_lg) <= n; cur_lg++)
    for (int i = 0; i < n; i += (1 << cur_lg))
      for (int j = 0; j < (1 << (cur_lg - 1)); j++) {
        int pos = (1 << (lg - cur_lg)) * j;
        if (invert) pos = ((1 << lg) - (1 << (lg - cur_lg)) * j);
        cd u = a[i + j];
        cd v = a[i + j + (1 << (cur_lg - 1))] * prec_w[pos];
        a[i + j] = u + v;
        a[i + j + (1 << (cur_lg - 1))] = u - v;
      }
  if (invert)
    for (int i = 0; i < n; i++) a[i] = a[i] / n;
}
vector<cd> mult(vector<cd> &a, vector<cd> &b) {
  vector<cd> res;
  vector<cd> fa(a.begin(), a.end());
  vector<cd> fb(b.begin(), b.end());
  int n = 1;
  while (n < (int)a.size() + (int)b.size()) n <<= 1;
  fa.resize(n);
  fb.resize(n);
  res.resize(n);
  fft(fa);
  fft(fb);
  for (int i = 0; i < n; i++) fa[i] = fa[i] * fb[i];
  fft(fa, 1);
  for (int i = 0; i < fa.size(); i++) res[i] = (int)(fa[i].real + 1e-4);
  return res;
}
vector<cd> get_scalar(vector<cd> &a, vector<cd> &b) {
  vector<cd> ans;
  reverse(b.begin(), b.end());
  vector<cd> res = mult(a, b);
  for (int i = (int)b.size() - 1; i < a.size(); i++) ans.push_back(res[i]);
  return ans;
}
vector<cd> get(string second, string t) {
  vector<cd> a, b;
  for (int i = 0; i < second.size(); i++) {
    double alp = PI * (second[i] - 'a') / 26;
    a.push_back(cd(cos(alp), sin(alp)));
  }
  for (int i = 0; i < t.size(); i++) {
    if (t[i] >= 'a' && t[i] <= 'z') {
      double alp = PI * (t[i] - 'a') / 26;
      b.push_back(cd(cos(alp), -sin(alp)));
    } else
      b.push_back(cd(0, 0));
  }
  return get_scalar(a, b);
}
int n, m, r, c;
string a[N], b[N];
string second, t;
vector<string> v;
int cnt;
int main() {
  ios_base::sync_with_stdio(0);
  precomp(20);
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    v.push_back(a[i]);
  }
  cin >> r >> c;
  for (int i = 0; i < r; i++) {
    cin >> b[i];
    for (int j = 0; j < b[i].size(); j++)
      if (b[i][j] == '?') cnt++;
  }
  for (int i = 0; i < v.size(); i++) {
    string ss = v[i];
    while (v[i].size() < m + c) v[i] += ss;
  }
  int pos = 0;
  while (v.size() < n + r) {
    v.push_back(v[pos % n]);
    pos++;
  }
  int w = (int)v[0].size();
  for (string x : v) second += x;
  for (int i = 0; i < r; i++) {
    t += b[i];
    for (int j = (int)b[i].size(); j < w; j++) t += "#";
  }
  vector<cd> kilk = get(second, t);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++)
      if (kilk[i * w + j].real + cnt == r * c)
        cout << 1;
      else
        cout << 0;
    cout << '\n';
  }
}
