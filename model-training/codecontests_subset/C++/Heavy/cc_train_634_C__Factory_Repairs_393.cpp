#include <bits/stdc++.h>
using namespace std;
int break_point() {
  char c;
  while ((c = getchar()) != '\n')
    ;
  return 0;
}
template <typename T>
void read_integer(T &r) {
  bool sign = 0;
  r = 0;
  char c;
  while (1) {
    c = getchar();
    if (c == '-') {
      sign = 1;
      break;
    }
    if (c != ' ' && c != '\n') {
      r = c - '0';
      break;
    }
  }
  while (1) {
    c = getchar();
    if (c == ' ' || c == '\n') break;
    r = r * 10 + (c - '0');
  }
  if (sign) r = -r;
}
long long binpowmod(long long a, long long b, long long mod) {
  if (b == 0) return 1;
  long long c = binpowmod(a, b >> 1, mod);
  return (((c * c) % mod) * (b & 1 ? a : 1)) % mod;
}
long long binpow(long long a, long long b) {
  if (b == 0) return 1;
  long long c = binpow(a, b >> 1);
  return c * c * (b & 1 ? a : 1);
}
inline int getbit(int x, int b) { return (x >> b) & 1; }
inline long long getbit(long long x, int b) { return (x >> b) & 1; }
inline unsigned long long getbit(unsigned long long x, int b) {
  return (x >> b) & 1;
}
inline int setbit(int x, int b) { return x | (1 << b); }
inline void _setbit(int &x, int b) { x = setbit(x, b); }
inline long long setbit(long long x, int b) { return x | (1ll << b); }
inline void _setbit(long long &x, int b) { x = setbit(x, b); }
inline int unsetbit(int x, int b) { return x & (INT_MAX - (1 << b)); }
inline void _unsetbit(int &x, int b) { x = unsetbit(x, b); }
inline int countbit(int x) {
  x = x - ((x >> 1) & 0x55555555);
  x = (x & 0x33333333) + ((x >> 2) & 0x33333333);
  return ((x + (x >> 4) & 0xF0F0F0F) * 0x1010101) >> 24;
}
inline long long countbit(long long x) {
  int p1 = (x >> 32) & ((1ll << 32) - 1);
  int p2 = x & ((1ll << 32) - 1);
  return countbit(p1) + countbit(p2);
}
template <typename T>
void printbit(T x, int len) {
  for (int i = len - 1; i >= 0; i--) printf("%d", getbit(x, i));
}
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
template <typename A, typename B>
ostream &operator<<(ostream &stream, const pair<A, B> &p) {
  stream << "{" << p.first << "," << p.second << "}";
  return stream;
}
template <typename A>
ostream &operator<<(ostream &stream, const vector<A> &v) {
  stream << "[";
  for (auto itr = v.begin(); itr != v.end(); itr++) stream << *itr << " ";
  stream << "]";
  return stream;
}
template <typename A, typename B>
ostream &operator<<(ostream &stream, const map<A, B> &v) {
  stream << "[";
  for (auto itr = v.begin(); itr != v.end(); itr++) stream << *itr << " ";
  stream << "]";
  return stream;
}
template <typename A>
ostream &operator<<(ostream &stream, const set<A> &v) {
  stream << "[";
  for (auto itr = v.begin(); itr != v.end(); itr++) stream << *itr << " ";
  stream << "]";
  return stream;
}
template <typename A>
ostream &operator<<(ostream &stream, const stack<A> &v) {
  stack<A> st;
  stream << "[";
  while (!st.empty()) {
    stream << st.top() << " ";
    st.pop();
  }
  stream << "]";
  return stream;
}
template <typename A>
ostream &operator<<(ostream &stream, const priority_queue<A> &v) {
  priority_queue<A> q = v;
  stream << "[";
  while (!q.empty()) {
    stream << q.top() << " ";
    q.pop();
  }
  stream << "]";
  return stream;
}
void run();
int main() {
  srand(time(NULL));
  do {
    run();
    if (0) {
      0 ? printf("-------------------------------\n") : 0;
      0 ? printf("-------------------------------\n") : 0;
    }
  } while (0);
  return 0;
}
struct SegmentTree {
  vector<long long> tr;
  int n, mx;
  SegmentTree(int _n, int _mx) : n(_n), mx(_mx) { tr.resize(4 * n); }
  void update_impl(int v, int l, int r, int pos, long long d) {
    if (l == r)
      tr[v] = min(1ll * mx, tr[v] + d);
    else {
      int mid = (l + r) >> 1;
      if (pos <= mid)
        update_impl(v + v, l, mid, pos, d);
      else
        update_impl(v + v + 1, mid + 1, r, pos, d);
      tr[v] = tr[v + v] + tr[v + v + 1];
    }
  }
  long long get_sum_impl(int v, int l, int r, int L, int R) {
    if (L > R) return 0;
    if (l == L && r == R)
      return tr[v];
    else {
      int mid = (l + r) >> 1;
      return get_sum_impl(v + v, l, mid, L, min(mid, R)) +
             get_sum_impl(v + v + 1, mid + 1, r, max(mid + 1, L), R);
    }
  }
  long long get_sum(int l, int r) { return get_sum_impl(1, 0, n - 1, l, r); }
  void update(int pos, long long d) { update_impl(1, 0, n - 1, pos, d); }
};
void run() {
  int n, k, a, b, q;
  scanf("%d%d", &n, &k);
  scanf("%d%d%d", &a, &b, &q);
  int t, x, y;
  SegmentTree atree(n + 2, a), btree(n + 2, b);
  while (q--) {
    scanf("%d%d", &t, &x);
    if (t == 1) {
      scanf("%d", &y);
      atree.update(x, y);
      btree.update(x, y);
    } else {
      long long res = btree.get_sum(1, x - 1) + atree.get_sum(x + k, n);
      printf(0 ? "%lld" : "%I64d", res);
      putchar('\n');
    }
  }
}
