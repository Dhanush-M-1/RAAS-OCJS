#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void read(T &x) {
  bool b = 0;
  char c;
  while (!isdigit(c = getchar()) && c != '-')
    ;
  if (c == '-') c = getchar(), b = 1;
  x = c - 48;
  while (isdigit(c = getchar())) x = (x << 3) + (x << 1) + c - 48;
  if (b) x = -x;
}
template <typename T>
inline void wrip(T x) {
  if (x > 9) wrip(x / 10);
  putchar(x % 10 + 48);
}
template <typename T>
inline void write(T x) {
  if (x < 0) putchar('-'), x = -x;
  wrip(x);
}
void reads(string &s) {
  char c;
  while (!isalpha(c = getchar()))
    ;
  s = c;
  while (isalpha(c = getchar())) s += c;
}
const long long mod = 1e9 + 7;
const int N = 2e5 + 11;
int n, a[N];
long long s[N], it[4 * N], lazy[4 * N];
void push(int id) {
  it[id << 1] += lazy[id];
  it[(id << 1) + 1] += lazy[id];
  lazy[id << 1] += lazy[id];
  lazy[(id << 1) + 1] += lazy[id];
  lazy[id] = 0;
}
void update(int id, int l, int r, int u, int v, long long val) {
  if (l > v || r < u) return;
  if (u <= l && r <= v) {
    lazy[id] += val;
    it[id] += val;
    return;
  }
  if (lazy[id]) push(id);
  int mid = l + r >> 1;
  update(id << 1, l, mid, u, v, val);
  update((id << 1) + 1, mid + 1, r, u, v, val);
  it[id] = min(it[id << 1], it[(id << 1) + 1]);
}
int Find(int id, int l, int r, long long val) {
  if (it[id] > val) return l - 1;
  if (l == r) return l;
  if (lazy[id]) push(id);
  int mid = l + r >> 1;
  if (it[(id << 1) + 1] <= val) return Find((id << 1) + 1, mid + 1, r, val);
  return Find(id << 1, l, mid, val);
}
int main() {
  read(n);
  for (int i = 1; i <= n; i++) read(s[i]);
  for (int i = 1; i <= n; i++) {
    s[0] += i;
    update(1, 1, n, i, i, s[0]);
  }
  for (int i = n; i > 0; i--) {
    int pos = Find(1, 1, n, s[i]);
    a[i] = pos + 1;
    update(1, 1, n, pos + 1, n, -a[i]);
  }
  for (int i = 1; i <= n; i++) {
    write(a[i]);
    putchar(' ');
  }
}
