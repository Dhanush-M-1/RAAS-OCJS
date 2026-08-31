#include <bits/stdc++.h>
using namespace std;
template <typename T>
T Abs(T x) {
  return x > 0 ? x : -x;
}
template <typename T>
T const& Max(T const& a, T const& b) {
  return a > b ? a : b;
}
template <typename T>
T const& Min(T const& a, T const& b) {
  return a < b ? a : b;
}
template <typename T>
inline T gcd(T a, T b) {
  return (b ? gcd(b, a % b) : a);
}
template <typename T>
T sqaa(T a) {
  return a * a;
}
long long int Pow(long long int a, long long int pow) {
  long long int ret = 1;
  for (; pow; pow >>= 1) {
    if (pow & 1) ret = (ret * a);
    a = (a * a);
  }
  return ret;
}
long long int modPow(long long int a, long long int pow, long long int mod) {
  long long int ret = 1;
  for (; pow; pow >>= 1) {
    if (pow & 1) ret = (ret * a) % mod;
    a = (a * a) % mod;
  }
  return ret;
}
long long int modINV(long long int a, long long int M) {
  return modPow(a, M - 2, M);
}
const int mx = 2e5 + 10;
int tra[mx * 3];
int trb[mx * 3];
int ar[mx];
int n, k, a, b, q, ai, kk, d;
void upda(int node, int s, int e, int idx, int val) {
  if (s == e) {
    tra[node] = min(val, b);
    return;
  }
  int mid = (s + e) / 2;
  int left = node * 2;
  int right = node * 2 + 1;
  if (idx <= mid)
    upda(left, s, mid, idx, val);
  else
    upda(right, mid + 1, e, idx, val);
  tra[node] = tra[left] + tra[right];
}
void updb(int node, int s, int e, int idx, int val) {
  if (s == e) {
    trb[node] = min(val, a);
    return;
  }
  int mid = (s + e) / 2;
  int left = node * 2;
  int right = node * 2 + 1;
  if (idx <= mid)
    updb(left, s, mid, idx, val);
  else
    updb(right, mid + 1, e, idx, val);
  trb[node] = trb[left] + trb[right];
}
int qua(int node, int s, int e, int i, int j) {
  if (i > e || j < s) return 0;
  if (s >= i && e <= j) {
    return tra[node];
  }
  int mid = (s + e) / 2;
  int left = node * 2;
  int right = node * 2 + 1;
  return qua(left, s, mid, i, j) + qua(right, mid + 1, e, i, j);
}
int qub(int node, int s, int e, int i, int j) {
  if (i > e || j < s) return 0;
  if (s >= i && e <= j) {
    return trb[node];
  }
  int mid = (s + e) / 2;
  int left = node * 2;
  int right = node * 2 + 1;
  return qub(left, s, mid, i, j) + qub(right, mid + 1, e, i, j);
}
int main() {
  long long int ri, lef;
  while (~scanf("%d %d %d %d %d", &n, &k, &a, &b, &q)) {
    memset(tra, 0, sizeof(tra));
    memset(trb, 0, sizeof(trb));
    memset(ar, 0, sizeof(ar));
    for (int i = 0; i < q; i++) {
      scanf("%d %d", &d, &ai);
      if (d == 1) {
        scanf("%d", &kk);
        ar[ai] += kk;
        upda(1, 1, n, ai, ar[ai]);
        updb(1, 1, n, ai, ar[ai]);
      } else {
        ri = 0, lef = 0;
        if (ai > 1) {
          ri = qua(1, 1, n, 1, ai - 1);
        }
        if (ai + k <= n) {
          lef = qub(1, 1, n, ai + k, n);
        }
        printf("%lld\n", lef + ri);
      }
    }
  }
  return 0;
}
