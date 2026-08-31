#include <bits/stdc++.h>
using namespace std;
template <typename T>
void _R(T &x) {
  cin >> x;
}
template <typename T>
void _R(vector<T> &x) {
  for (auto it = x.begin(); it != x.end(); it++) {
    _R(*it);
  }
}
void R() {}
template <typename T, typename... K>
void R(T &head, K &...tail) {
  _R(head);
  R(tail...);
}
template <typename T>
void _W(const T &x, const char c) {
  cout << x;
}
template <typename T>
void _W(const vector<T> &x, const char c) {
  for (auto it = x.cbegin(); it != x.cend(); it++) {
    if (it != x.cbegin()) putchar(c);
    _W(*it, c);
  }
}
void W() {}
template <typename T, typename... K>
void W(const T &head, const K &...tail) {
  _W(head, ' ');
  cout << (sizeof...(tail) ? ' ' : '\n') << flush;
  W(tail...);
}
const double PI =
    3.14159265358979323846264338327950288419716939937510582097494459230;
template <typename T>
inline T gcd(T a, T b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
template <typename T>
inline void amin(T &x, T y) {
  if (x > y) x = y;
}
template <typename T>
inline void amax(T &x, T y) {
  if (x < y) x = y;
}
template <typename A, typename B>
class comp {
 public:
  bool operator()(const pair<A, B> &a, const pair<A, B> &b) {
    if (a.first != b.first)
      return a.first < b.first;
    else
      return a.first > b.first;
  }
};
long long fast_exp(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b & 1LL) {
      res *= a;
      res %= 1000000007;
    }
    b >>= 1LL;
    a *= a;
    a %= 1000000007;
  }
  return res;
}
int n, d;
vector<int> a, S;
vector<long long> st, lazy;
void preprocess(void) { return; }
void build(int v, int l, int r) {
  if (l > r) {
    return;
  }
  if (l == r) {
    st[v] = S[l];
    return;
  }
  int mid = (l + r) >> 1;
  build(((v) << 1), l, mid);
  build((((v) << 1) + 1), mid + 1, r);
  st[v] = max(st[((v) << 1)], st[(((v) << 1) + 1)]);
}
void update(int v, int ql, int qr, int l, int r, long long diff) {
  if (lazy[v] != 0) {
    st[v] = st[v] + lazy[v];
    if (l != r) {
      lazy[((v) << 1)] += lazy[v];
      lazy[(((v) << 1) + 1)] += lazy[v];
    }
    lazy[v] = 0;
  }
  if (l > qr || r < ql) {
    return;
  }
  if (l >= ql && r <= qr) {
    st[v] += diff;
    if (l != r) {
      lazy[((v) << 1)] += diff;
      lazy[(((v) << 1) + 1)] += diff;
    }
    return;
  }
  int mid = (l + r) >> 1;
  update(((v) << 1), ql, qr, l, mid, diff);
  update((((v) << 1) + 1), ql, qr, mid + 1, r, diff);
  st[v] = max(st[((v) << 1)], st[(((v) << 1) + 1)]);
}
long long query(int v, int ql, int qr, int l, int r) {
  if (lazy[v] != 0) {
    st[v] = st[v] + lazy[v];
    if (l != r) {
      lazy[((v) << 1)] += lazy[v];
      lazy[(((v) << 1) + 1)] += lazy[v];
    }
    lazy[v] = 0;
  }
  if (l > qr || r < ql) {
    return -1000000007;
  }
  if (l >= ql && r <= qr) {
    return st[v];
  }
  int mid = (l + r) >> 1;
  return max(query(((v) << 1), ql, qr, l, mid),
             query((((v) << 1) + 1), ql, qr, mid + 1, r));
}
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.precision(20);
  preprocess();
  int teeee;
  teeee = 1;
  for (int zeeee = (1); zeeee <= (teeee); zeeee++) {
    R(n, d);
    a.resize(n), S.resize(n + 1);
    R(a);
    S[0] = 0;
    for (int i = (1); i <= (n); i++) {
      S[i] = S[i - 1] + a[i - 1];
    };
    for (int i = (0); i <= ((int)(n)-1); i++) {
      if (S[i + 1] > d) {
        W(-1);
        exit(0);
      }
    }
    st.resize(6 * n + 4);
    lazy.assign(6 * n + 4, 0);
    build(1, 1, n);
    int cnt = 0;
    for (int i = (1); i <= (n); i++) {
      if (a[i - 1] == 0) {
        long long q1 = query(1, i, i, 1, n);
        ;
        if (q1 < 0) {
          long long q = query(1, i, n, 1, n);
          ;
          if (q > d) {
            W(-1);
            exit(0);
          }
          if (q - q1 > d) {
            W(-1);
            exit(0);
          }
          cnt++;
          update(1, i, n, 1, n, d - (q));
        }
      }
    }
    W(cnt);
  }
  cerr << (clock() / (double)CLOCKS_PER_SEC) << endl;
  return 0;
}
