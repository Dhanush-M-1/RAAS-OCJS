#include <bits/stdc++.h>
using namespace std;
template <typename T>
T BigMod(T b, T p, T m) {
  if (p == 0) return 1;
  if (p % 2 == 0) {
    T s = BigMod(b, p / 2, m);
    return ((s % m) * (s % m)) % m;
  }
  return ((b % m) * (BigMod(b, p - 1, m) % m)) % m;
}
template <typename T>
T ModInv(T b, T m) {
  return BigMod(b, m - 2, m);
}
template <typename T>
T in() {
  char ch;
  T n = 0;
  bool ng = false;
  while (1) {
    ch = getchar();
    if (ch == '-') {
      ng = true;
      ch = getchar();
      break;
    }
    if (ch >= '0' && ch <= '9') break;
  }
  while (1) {
    n = n * 10 + (ch - '0');
    ch = getchar();
    if (ch < '0' || ch > '9') break;
  }
  return (ng ? -n : n);
}
template <typename T>
T POW(T B, T printf) {
  if (printf == 0) return 1;
  if (printf & 1)
    return B * POW(B, printf - 1);
  else
    return (POW(B, printf / 2) * POW(B, printf / 2));
}
template <typename T>
T Bigmod(T b, T p, T m) {
  if (p == 0)
    return 1;
  else if (!(p & 1))
    return (Bigmod(b, p / 2, m) * Bigmod(b, p / 2, m)) % m;
  else
    return ((b % m) * Bigmod(b, p - 1, m)) % m;
}
template <typename T>
T Dis(T x1, T y1, T x2, T y2) {
  return sqrt((x1 - x2 * x1 - x2) + (y1 - y2 * y1 - y2));
}
template <typename T>
T Angle(T x1, T y1, T x2, T y2) {
  return atan(double(y1 - y2) / double(x1 - x2));
}
template <typename T>
T DIFF(T a, T b) {
  T d = a - b;
  if (d < 0)
    return -d;
  else
    return d;
}
template <typename T>
T ABS(T a) {
  if (a < 0)
    return -a;
  else
    return a;
}
template <typename T>
T gcd(T a, T b) {
  if (a < 0) return gcd(-a, b);
  if (b < 0) return gcd(a, -b);
  return (b == 0) ? a : gcd(b, a % b);
}
template <typename T>
T lcm(T a, T b) {
  if (a < 0) return lcm(-a, b);
  if (b < 0) return lcm(a, -b);
  return a * (b / gcd(a, b));
}
template <typename T>
T euclide(T a, T b, T& x, T& y) {
  if (a < 0) {
    T d = euclide(-a, b, x, y);
    x = -x;
    return d;
  }
  if (b < 0) {
    T d = euclide(a, -b, x, y);
    y = -y;
    return d;
  }
  if (b == 0) {
    x = 1;
    y = 0;
    return a;
  } else {
    T d = euclide(b, a % b, x, y);
    T t = x;
    x = y;
    y = t - (a / b) * y;
    return d;
  }
}
template <typename T>
void ia(T a[], int n) {
  for (int i = 0; i < n; i++) cin >> a[i];
}
template <typename T>
void pa(T a[], int n) {
  for (int i = 0; i < n - 1; i++) cout << a[i] << " ";
  cout << a[n - 1] << endl;
}
template <typename T>
long long int isLeft(T a, T b, T c) {
  return (a.x - b.x) * (b.y - c.y) - (b.x - c.x) * (a.y - b.y);
}
int Set(int N, int pos) { return N = N | (1 << pos); }
int Reset(int N, int pos) { return N = N & ~(1 << pos); }
bool Check(int N, int pos) { return (bool)(N & (1 << pos)); }
template <class T, class first>
inline T togglebit(T a, first i) {
  T t = 1;
  return (a ^ (t << i));
}
double DEG(double x) { return (180.0 * x) / (2.0 * acos(0.0)); }
double RAD(double x) { return (x * (double)2.0 * acos(0.0)) / (180.0); }
template <class T>
struct Vector {
  T* ar;
  int sz;
  int cap;
  Vector() {
    cap = 1;
    sz = 0;
    ar = (T*)malloc(cap * sizeof(T));
  }
  Vector(int n) {
    cap = n;
    sz = n;
    ar = (T*)calloc(cap, sizeof(T));
  }
  void push_back(T x) {
    if (sz == cap) {
      cap = cap + ((cap + 1) >> 1);
      ar = (T*)realloc(ar, cap * sizeof(T));
    }
    ar[sz++] = x;
  }
  void clear() {
    cap = 1;
    sz = 0;
    free(ar);
    ar = (T*)malloc(cap * sizeof(T));
  }
  void sort(int l, int r) { std::sort(ar + l, ar + r + 1); }
  T& operator[](int idx) { return ar[idx]; }
  int size() { return sz; }
};
struct Edge {
  int u, v, w, i;
  Edge() {}
  Edge(int _u, int _v, int _w, int _i) {
    u = _u;
    v = _v;
    w = _w;
    i = _i;
  }
  bool operator<(const Edge& p) const { return w < p.w; }
};
int par[1007], color[1007];
Vector<int> comp[1007];
Vector<Edge> e;
void Init(int n) {
  for (int i = 0; i <= n; i++) {
    par[i] = i;
    color[i] = 0;
    comp[i].clear();
    comp[i].push_back(i);
  }
}
int FindPar(int n) {
  if (par[n] == n)
    return n;
  else
    return par[n] = FindPar(par[n]);
}
int main() {
  int n, m, q;
  scanf("%d%d%d", &n, &m, &q);
  e = Vector<Edge>(m + 2);
  for (int i = 1; i <= m; i++) {
    int u, v, w;
    scanf("%d%d%d", &u, &v, &w);
    e[i] = Edge(u, v, w, i);
  }
  e.sort(1, m);
  while (q--) {
    int l, r;
    scanf("%d%d", &l, &r);
    Init(n);
    int res = -1;
    for (int i = m; i; i--) {
      if (e[i].i < l || e[i].i > r) continue;
      int u = FindPar(e[i].u), v = FindPar(e[i].v), w = e[i].w;
      if (u != v) {
        if (comp[u].size() < comp[v].size()) swap(u, v);
        int f = (color[e[i].u] == color[e[i].v]);
        for (int j = 0; j < comp[v].size(); j++) {
          int x = comp[v][j];
          color[x] ^= f;
          comp[u].push_back(x);
          par[x] = u;
        }
        comp[v].clear();
      } else if (color[e[i].u] == color[e[i].v]) {
        res = max(res, w);
        break;
      }
    }
    printf("%d\n", res);
  }
  return 0;
}
