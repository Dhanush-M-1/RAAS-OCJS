#include <bits/stdc++.h>
using namespace std;
template <class T>
bool tomin(T &x, T y) {
  return y < x ? x = y, 1 : 0;
}
template <class T>
bool tomax(T &x, T y) {
  return x < y ? x = y, 1 : 0;
}
template <class T>
void read(T &x) {
  char c;
  x = 0;
  int f = 1;
  while (c = getchar(), c < '0' || c > '9')
    if (c == '-') f = -1;
  do x = (x << 3) + (x << 1) + (c ^ 48);
  while (c = getchar(), c >= '0' && c <= '9');
  x *= f;
}
bool mem1;
const double Pi = acos(-1);
const int maxn = 2e5 + 5;
int n;
long long A[maxn];
int ans[maxn];
long long c[maxn];
void Add(int x, int v) {
  while (x <= n) {
    c[x] += v;
    x += x & -x;
  }
}
long long query(int x) {
  long long res = 0;
  while (x) {
    res += c[x];
    x &= x - 1;
  }
  return res;
}
bool mem2;
int main() {
  srand(time(NULL));
  read(n);
  for (int i = 1, i_ = n; i <= i_; ++i) read(A[i]);
  for (int i = 1, i_ = n; i <= i_; ++i) Add(i, i);
  for (int i = n, i_ = 1; i >= i_; --i) {
    int L = 0, R = n - 1, mid, res;
    while (L <= R) {
      if (query(mid = L + R >> 1) <= A[i])
        L = (res = mid) + 1;
      else
        R = mid - 1;
    }
    ans[i] = res + 1;
    Add(ans[i], -ans[i]);
  }
  for (int i = 1, i_ = n; i <= i_; ++i) printf("%d ", ans[i]);
  return 0;
}
