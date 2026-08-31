#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-9;
const int inf = 2000000000;
const long long infLL = 9000000000000000000;
template <typename first, typename second>
ostream &operator<<(ostream &os, const pair<first, second> &p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <typename T>
ostream &operator<<(ostream &os, const vector<T> &v) {
  os << "{";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "}";
}
template <typename T>
ostream &operator<<(ostream &os, const set<T> &v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ",";
    os << *it;
  }
  return os << "]";
}
template <typename T>
ostream &operator<<(ostream &os, const multiset<T> &v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "]";
}
template <typename first, typename second>
ostream &operator<<(ostream &os, const map<first, second> &v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << it->first << " = " << it->second;
  }
  return os << "]";
}
void faltu() { cerr << '\n'; }
template <typename T>
void faltu(T a[], int n) {
  for (int i = 0; i < n; ++i) cerr << a[i] << ' ';
  cerr << '\n';
}
template <typename T, typename... hello>
void faltu(T arg, const hello &...rest) {
  cerr << arg << ' ';
  faltu(rest...);
}
struct FFT_2D {
  struct node {
    double x, y;
    node() {}
    node(double a, double b) : x(a), y(b) {}
    node operator+(const node &a) const {
      return node(this->x + a.x, this->y + a.y);
    }
    node operator-(const node a) const {
      return node(this->x - a.x, this->y - a.y);
    }
    node operator*(const node a) const {
      return node(this->x * a.x - this->y * a.y, this->x * a.y + a.x * this->y);
    }
  };
  int N, M;
  vector<vector<node>> A, B;
  vector<node> w[2][2];
  vector<int> rev[2];
  long double pi;
  FFT_2D() { pi = 3.1415926535897932384; }
  void init(int n, int m) {
    N = 1;
    while (N < n) N <<= 1;
    N <<= 1;
    A.resize(N);
    B.resize(N);
    w[0][0].resize(N);
    w[0][1].resize(N);
    rev[0].resize(N);
    for (int i = 0; i < N; i++) {
      int j = i, y = 0;
      for (int x = 1; x < N; x <<= 1, j >>= 1) (y <<= 1) += j & 1;
      rev[0][i] = y;
    }
    for (int i = 0; i < N; i++) {
      w[0][0][i] = node(cos(2 * pi * i / N), sin(2 * pi * i / N));
      w[0][1][i] = node(cos(2 * pi * i / N), -sin(2 * pi * i / N));
    }
    M = 1;
    while (M < m) M <<= 1;
    M <<= 1;
    for (int i = 0; i < N; i++) A[i].resize(M), B[i].resize(M);
    w[1][0].resize(M);
    w[1][1].resize(M);
    rev[1].resize(M);
    for (int i = 0; i < M; i++) {
      int j = i, y = 0;
      for (int x = 1; x < M; x <<= 1, j >>= 1) (y <<= 1) += j & 1;
      rev[1][i] = y;
    }
    for (int i = 0; i < M; i++) {
      w[1][0][i] = node(cos(2 * pi * i / M), sin(2 * pi * i / M));
      w[1][1][i] = node(cos(2 * pi * i / M), -sin(2 * pi * i / M));
    }
  }
  void ftransform_2D(vector<vector<node>> &A, int p) {
    for (int z = 0; z < N; z++) {
      for (int i = 0; i < M; i++)
        if (i < rev[1][i]) swap(A[z][i], A[z][rev[1][i]]);
      for (int i = 1; i < M; i <<= 1)
        for (int j = 0, t = M / (i << 1); j < M; j += i << 1)
          for (int k = 0, l = 0; k < i; k++, l += t) {
            node x = A[z][i + j + k] * w[1][p][l];
            node y = A[z][j + k];
            A[z][j + k] = y + x;
            A[z][j + k + i] = y - x;
          }
      if (p)
        for (int i = 0; i < M; i++) A[z][i].x /= M, A[z][i].y /= M;
    }
    for (int z = 0; z < M; z++) {
      for (int i = 0; i < N; i++)
        if (i < rev[0][i]) swap(A[i][z], A[rev[0][i]][z]);
      for (int i = 1; i < N; i <<= 1)
        for (int j = 0, t = N / (i << 1); j < N; j += i << 1)
          for (int k = 0, l = 0; k < i; k++, l += t) {
            node x = w[0][p][l] * A[i + j + k][z];
            node y = A[j + k][z];
            A[j + k][z] = y + x;
            A[j + k + i][z] = y - x;
          }
      if (p)
        for (int i = 0; i < N; i++) A[i][z].x /= N;
    }
  }
  void multiply_2D(vector<vector<long long>> &P, vector<vector<long long>> &Q,
                   vector<vector<long long>> &res) {
    init(max(P.size(), Q.size()), max(P[0].size(), Q[0].size()));
    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        A[i][j].x = A[i][j].y = B[i][j].x = B[i][j].y = 0;
    for (int i = 0; i < P.size(); i++)
      for (int j = 0; j < P[i].size(); j++) A[i][j].x = P[i][j];
    for (int i = 0; i < Q.size(); i++)
      for (int j = 0; j < Q[i].size(); j++) B[i][j].x = Q[i][j];
    ftransform_2D(A, 0);
    ftransform_2D(B, 0);
    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++) A[i][j] = A[i][j] * B[i][j];
    ftransform_2D(A, 1);
    res.resize(N);
    for (int i = 0; i < N; i++) res[i].resize(M);
    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++) res[i][j] = round(A[i][j].x);
  }
} fft_2D;
string t[805], p[805];
vector<string> vec;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; ++i) cin >> t[i];
  vec.resize(n);
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      vec[i].push_back('0');
    }
  }
  int r, c;
  cin >> r >> c;
  for (int i = 0; i < r; ++i) cin >> p[i];
  for (int i = n; i < n + r; ++i) {
    t[i] = t[i % n];
  }
  n = n + r;
  for (int i = 0; i < n; ++i) {
    string temp = t[i];
    while (t[i].size() < m + c) t[i] += temp;
  }
  m = t[0].size();
  vector<vector<long long>> a(n, vector<long long>(m)),
      b(r, vector<long long>(c)), store, ans(n + r, vector<long long>(m + c));
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      int num = t[i][j] - 'a' + 1;
      a[i][j] = num * num * num;
      if (t[i][j] == '?') a[i][j] = 0;
    }
  }
  for (int i = 0; i < r; ++i) {
    for (int j = 0; j < c; ++j) {
      int num = p[i][j] - 'a' + 1;
      b[r - i - 1][c - j - 1] = num;
      if (p[i][j] == '?') b[r - i - 1][c - j - 1] = 0;
    }
  }
  fft_2D.multiply_2D(a, b, store);
  for (int i = 0; i < n + r; ++i) {
    for (int j = 0; j < m + c; ++j) {
      ans[i][j] = store[i][j];
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      int num = t[i][j] - 'a' + 1;
      a[i][j] = 2 * num * num;
      if (t[i][j] == '?') a[i][j] = 0;
    }
  }
  for (int i = 0; i < r; ++i) {
    for (int j = 0; j < c; ++j) {
      int num = p[i][j] - 'a' + 1;
      b[r - i - 1][c - j - 1] = num * num;
      if (p[i][j] == '?') b[r - i - 1][c - j - 1] = 0;
    }
  }
  fft_2D.multiply_2D(a, b, store);
  for (int i = 0; i < n + r; ++i) {
    for (int j = 0; j < m + c; ++j) {
      ans[i][j] -= store[i][j];
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      int num = t[i][j] - 'a' + 1;
      a[i][j] = num;
      if (t[i][j] == '?') a[i][j] = 0;
    }
  }
  for (int i = 0; i < r; ++i) {
    for (int j = 0; j < c; ++j) {
      int num = p[i][j] - 'a' + 1;
      b[r - i - 1][c - j - 1] = num * num * num;
      if (p[i][j] == '?') b[r - i - 1][c - j - 1] = 0;
    }
  }
  fft_2D.multiply_2D(a, b, store);
  for (int i = 0; i < n + r; ++i) {
    for (int j = 0; j < m + c; ++j) {
      ans[i][j] += store[i][j];
    }
  }
  for (int i1 = 0, i2 = r - 1; i2 < n; ++i2, ++i1) {
    for (int j1 = 0, j2 = c - 1; j2 < m; ++j1, ++j2) {
      if (i1 == vec.size() || j1 == vec[0].size()) break;
      if (ans[i2][j2] == 0) vec[i1][j1] = '1';
    }
  }
  for (int i = 0; i < vec.size(); ++i) cout << vec[i] << '\n';
}
