#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double eps = 1e-11;
template <class T>
inline void ckmin(T& a, T b) {
  if (b < a) a = b;
}
template <class T>
inline void ckmax(T& a, T b) {
  if (b > a) a = b;
}
template <class T>
inline T sqr(T x) {
  return x * x;
}
const int MOD = 998244353;
inline int ADD(int a, int b) {
  return (a + b >= MOD) ? (a + b - MOD) : (a + b);
}
inline void ADDTO(int& a, int b) {
  a = ((a + b >= MOD) ? (a + b - MOD) : (a + b));
}
inline int SUB(int a, int b) { return (a >= b) ? (a - b) : (a - b + MOD); }
inline void SUBTO(int& a, int b) { a = ((a >= b) ? (a - b) : (a - b + MOD)); }
inline int MUL(int a, int b) { return (long long)a * b % MOD; }
const int maxsize = 200000 + 16;
struct SArray {
  int total = 0;
  vector<int> s;
  void reset() {
    total = 0;
    s = vector<int>(16);
  }
  int get(int i) {
    if (i <= 0) return 0;
    if (i >= ((int)s.size())) return total;
    int r = 0;
    for (; i; i &= (i - 1)) ADDTO(r, s[i]);
    return r;
  }
  void update(int key, int delta) {
    delta = (delta % MOD + MOD) % MOD;
    while (key >= ((int)s.size())) {
      s.push_back(0);
      int at = ((int)s.size()) - 1;
      s[at] = SUB(total, get(at & (at - 1)));
    }
    for (int i = key; i < ((int)s.size()); i = (i | (i - 1)) + 1)
      ADDTO(s[i], delta);
    ADDTO(total, delta);
  }
};
int M;
int m;
SArray sum_f[maxsize];
int block_e[maxsize];
int e[maxsize];
int f[maxsize];
void init(int n) {
  M = (int)(sqrt(n + 1) + 1);
  m = n / M + 1;
  for (int i = 0; i < (n + 1); ++i) e[i] = 1;
  for (int i = 0; i < (m); ++i) {
    sum_f[i].reset();
    block_e[i] = 0;
  }
  for (int i = 0; i < (n + 1); ++i) f[i] = 0;
}
void update_one(int key, int delta) {
  int w = key / M;
  sum_f[w].update(e[key], -f[key]);
  e[key] += delta;
  sum_f[w].update(e[key], f[key]);
}
void update_one_block(int idx, int delta) { block_e[idx] += delta; }
void update_interval(int s, int t, int delta) {
  if (s > t) return;
  for (; s <= t && s % M != 0; s++) update_one(s, delta);
  for (; s <= t && t % M != M - 1; t--) update_one(t, delta);
  for (; s <= t; s += M) update_one_block(s / M, delta);
}
int main() {
  std::ios::sync_with_stdio(false);
  int n, limit;
  while (cin >> n >> limit) {
    vector<int> a(n);
    for (int i = 0; i < (n); ++i) {
      cin >> a[i];
      --a[i];
    }
    vector<int> p_val(n, -1), p_idx(n, -1);
    init(n);
    f[0] = 1;
    sum_f[0].update(1, 1);
    for (int i = 0; i < (n); ++i) {
      p_idx[i] = p_val[a[i]];
      p_val[a[i]] = i;
      if (p_idx[i] >= 0) update_interval(p_idx[p_idx[i]] + 1, p_idx[i], -1);
      update_interval(p_idx[i] + 1, i, 1);
      f[i + 1] = 0;
      for (int k = 0; k < (m); ++k)
        ADDTO(f[i + 1], sum_f[k].get(limit - block_e[k] + 1));
      sum_f[(i + 1) / M].update(1, f[i + 1]);
    }
    printf("%d\n", f[n]);
    break;
  }
  return 0;
}
