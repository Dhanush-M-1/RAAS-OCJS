#include <bits/stdc++.h>
using namespace std;
inline int Get() {
  int res = 0, q = 1;
  char ch = getchar();
  while ((ch < '0' || ch > '9') && ch != '-') ch = getchar();
  if (ch == '-') q = -1, ch = getchar();
  while (ch >= '0' && ch <= '9') res = res * 10 + ch - '0', ch = getchar();
  return res * q;
}
const double eps = 1e-12, pi = M_PI;
const int oo = (int)2e9;
const long long INF = (long long)1e17;
const int N = (int)1e5, mod = (int)5e6 + 7, BS = 1234567, TS = 3333331;
typedef int arr[N + 10];
arr up, rt, tup, trt, X, Y, ord;
int n;
int ls[mod], nt[N + 10], to[N + 10];
bool cmp1(const int &a, const int &b) {
  return X[a] < X[b] || (X[a] == X[b] && Y[a] > Y[b]);
}
bool cmp2(const int &a, const int &b) {
  return Y[a] < Y[b] || (Y[a] == Y[b] && X[a] > X[b]);
}
int Hash(int x, int y) {
  return ((long long)x * (long long)BS % mod +
          (long long)y * (long long)TS % mod) %
         mod;
}
void Insert(int x, int y) {
  to[y] = 0;
  if (!ls[x])
    ls[x] = y;
  else {
    int k = ls[x];
    for (; to[k]; k = to[k])
      ;
    to[k] = y;
  }
}
bool Find(int x, int y) {
  int ht = Hash(x, y);
  for (int k = ls[ht]; k; k = to[k]) {
    if (X[k] == x && Y[k] == y) return 1;
  }
  return 0;
}
int main() {
  scanf(
      "%d"
      "\n",
      &n);
  for (int i = (1), end = (n); i <= end; ++i)
    scanf(
        "%d"
        "%d"
        "\n",
        X + i, Y + i),
        Insert(Hash(X[i], Y[i]), i), ord[i] = i;
  X[0] = Y[0] = oo;
  sort(ord + 1, ord + n + 1, cmp1);
  for (int i = (1), end = (n); i <= end; ++i)
    if (X[ord[i]] == X[ord[i - 1]])
      up[ord[i]] = ord[i - 1], tup[ord[i]] = tup[ord[i - 1]] + 1;
  sort(ord + 1, ord + n + 1, cmp2);
  for (int i = (1), end = (n); i <= end; ++i)
    if (Y[ord[i]] == Y[ord[i - 1]])
      rt[ord[i]] = ord[i - 1], trt[ord[i]] = trt[ord[i - 1]] + 1;
  int ans = 0;
  for (int i = (1), end = (n); i <= end; ++i) {
    if (tup[i] < trt[i]) {
      for (int k = up[i]; k; k = up[k]) {
        int l = Y[k] - Y[i];
        if (Find(X[i] + l, Y[i]) && Find(X[i] + l, Y[i] + l)) ++ans;
      }
    } else {
      for (int k = rt[i]; k; k = rt[k]) {
        int l = X[k] - X[i];
        if (Find(X[i], Y[i] + l) && Find(X[i] + l, Y[i] + l)) ++ans;
      }
    }
  }
  printf(
      "%d"
      "\n",
      ans);
  return 0;
}
