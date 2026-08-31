#include <bits/stdc++.h>
using namespace std;
long long MOD = 1000000007;
long double EPS = 1e-9;
template <class second, class T>
ostream& operator<<(ostream& os, const pair<second, T>& p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <class T>
ostream& operator<<(ostream& os, const vector<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
ostream& operator<<(ostream& os, const unordered_set<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class second, class T>
ostream& operator<<(ostream& os, const unordered_map<second, T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
ostream& operator<<(ostream& os, const set<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
ostream& operator<<(ostream& os, const multiset<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class second, class T>
ostream& operator<<(ostream& os, const map<second, T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
void dbs(string str, T t) {
  cerr << str << " : " << t << "\n";
}
template <class T, class... second>
void dbs(string str, T t, second... s) {
  long long idx = str.find(',');
  cerr << str.substr(0, idx) << " : " << t << ",";
  dbs(str.substr(idx + 1), s...);
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
long long binpow(long long b, long long p, long long mod) {
  long long ans = 1;
  for (; p; p >>= 1) {
    if (p & 1) ans = ans * b % mod;
    b = b * b % mod;
  }
  return ans;
}
void pre() {}
class cpx {
 public:
  double x, y;
  cpx(double p = 0, double q = 0) : x(p), y(q) {}
  cpx operator+(const cpx& o) { return cpx(x + o.x, y + o.y); }
  cpx operator-(const cpx& o) { return cpx(x - o.x, y - o.y); }
  cpx operator*(const cpx& o) {
    return cpx(x * o.x - y * o.y, x * o.y + y * o.x);
  }
  cpx conj() { return cpx(x, -y); }
};
ostream& operator<<(ostream& os, const cpx& x) {
  return os << "(" << x.x << ' ' << x.y << ")";
}
const double pi = acos(-1.l);
const int N = 1 << 20;
cpx root[N];
void precalc() {
  for (int i = 0; i < N; ++i) {
    double ang = 2 * i * pi / N;
    root[i] = cpx(cos(ang), sin(ang));
  }
}
void fft(vector<cpx>& a, int f) {
  int i, j, k, l, n = a.size();
  cpx w, x, y;
  for (i = j = 0; i < n; ++i) {
    if (i > j) swap(a[i], a[j]);
    for (k = n >> 1; (j ^= k) < k; k >>= 1)
      ;
  }
  for (i = 2; i <= n; i <<= 1) {
    l = i >> 1;
    for (j = 0; j < n; j += i)
      for (k = 0; k < l; ++k) {
        w = root[k * (N / i)], w.y *= f;
        x = a[j + k], y = w * a[j + k + l];
        a[j + k] = x + y, a[j + k + l] = x - y;
      }
  }
  if (f == -1)
    for (i = 0; i < n; ++i) a[i].x /= n, a[i].y /= n;
}
vector<cpx> conv(vector<cpx>& a, vector<cpx>& b) {
  int n, m = a.size() + b.size() - 1;
  for (n = 1; n < m; n <<= 1)
    ;
  vector<cpx> A(n), B(n);
  for (int i = 0; i < int(a.size()); ++i) A[i] = a[i];
  for (int i = 0; i < int(b.size()); ++i) B[i] = b[i];
  fft(A, 1), fft(B, 1);
  for (int i = 0; i < n; ++i) A[i] = A[i] * B[i];
  fft(A, -1);
  A.resize(m);
  return A;
}
void fft2(vector<vector<cpx>>& a, int f) {
  int n = a.size();
  int m = a[0].size();
  for (int i = 0; i < n; ++i) {
    fft(a[i], f);
  }
  for (int i = 0; i < m; ++i) {
    vector<cpx> t;
    for (int j = 0; j < n; ++j) t.push_back(a[j][i]);
    fft(t, f);
    for (int j = 0; j < n; ++j) a[j][i] = t[j];
  }
}
void conv2(vector<vector<cpx>>& v, vector<vector<cpx>>& w) {
  int n = 1, vwn = v.size() + w.size() - 1;
  while (n < vwn) n <<= 1;
  v.resize(n), w.resize(n);
  int m = 1, vwm = v[0].size() + w[0].size() - 1;
  while (m < vwm) m <<= 1;
  for (auto& it : v) it.resize(m);
  for (auto& it : w) it.resize(m);
  fft2(v, 1);
  fft2(w, 1);
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j) v[i][j] = v[i][j] * w[i][j];
  fft2(v, -1);
}
long long n, m;
long long r, c;
char arr[801][801];
char pat[401][401];
int ans[2000][2000];
void solve() {
  long long n, m;
  precalc();
  cin >> n >> m;
  for (long long i = 0; i < n; ++i) cin >> arr[i];
  cin >> r >> c;
  for (long long i = 0; i < r; ++i) cin >> pat[i];
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      for (int I = i; I < n + r; I += n) {
        for (int J = j; J < m + c; J += m) {
          arr[I][J] = arr[i][j];
        }
      }
    }
  }
  vector<vector<cpx>> A(n + r, vector<cpx>(m + c)), B(r, vector<cpx>(c));
  for (long long i = 0; i < n + r; ++i) {
    for (long long j = 0; j < m + c; ++j) {
      double angle = (2 * pi * (arr[i][j] - 'a')) / 26;
      A[i][j] = cpx(cos(angle), sin(angle));
    }
  }
  int cc = 0;
  for (long long i = 0; i < r; ++i) {
    for (long long j = 0; j < c; ++j) {
      if (pat[i][j] == '?') {
        cc++;
        B[r - i - 1][c - j - 1] = cpx(0, 0);
      } else {
        double angle = -(2 * pi * (pat[i][j] - 'a')) / 26;
        B[r - i - 1][c - j - 1] = cpx(cos(angle), sin(angle));
      }
    }
  }
  conv2(A, B);
  for (long long i = 0; i < n; ++i) {
    for (long long j = 0; j < m; ++j) {
      int ans = A[i + r - 1][j + c - 1].x + 1e-5;
      cout << (ans == (r * c - cc));
    }
    cout << '\n';
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  pre();
  long long t = 1;
  for (long long i = 1; i <= t; i++) {
    solve();
  }
}
