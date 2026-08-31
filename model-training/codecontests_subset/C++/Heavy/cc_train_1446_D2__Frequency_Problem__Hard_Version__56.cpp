#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5, MOD = 998244353;
template <typename T>
void chkmax(T& x, T y) {
  if (y > x) x = y;
}
template <typename T>
void chkmin(T& x, T y) {
  if (y < x) x = y;
}
long long q_pow(long long a, long long b, long long p = MOD) {
  long long ret = 1;
  for (; b; a = a * a % p, b >>= 1)
    if (b & 1) ret = ret * a % p;
  return ret;
}
long long q_inv(long long x, long long p = MOD) { return q_pow(x, p - 2, p); }
struct node {
  int v, next;
} E[MAXN << 1];
int head[MAXN], Elen;
void add(int u, int v) {
  ++Elen, E[Elen].v = v, E[Elen].next = head[u], head[u] = Elen;
}
int N, B, ans, a[MAXN], cnt[MAXN], MX;
int sum[MAXN], sum1[MAXN], las[MAXN * 2];
int b[MAXN], bb[MAXN], mx;
int main() {
  scanf("%d", &N), B = sqrt(N);
  for (int i = 1; i <= N; ++i) scanf("%d", &a[i]), ++cnt[a[i]];
  for (int i = 1; i <= N; ++i)
    if (cnt[i] > cnt[MX]) MX = i;
  for (int i = 1; i <= N; ++i) sum[i] = sum[i - 1] + (a[i] == MX);
  for (int i = 1; i <= N; ++i)
    if (i != MX && cnt[i] > B) {
      for (int j = 1; j <= N; ++j) sum1[j] = sum1[j - 1] + (a[j] == i);
      for (int j = 0; j <= 2 * N; ++j) las[j] = -1;
      for (int j = 0; j <= N; ++j) {
        int v = sum[j] - sum1[j] + N;
        if (las[v] != -1)
          chkmax(ans, j - las[v]);
        else
          las[v] = j;
      }
    }
  for (int i = 1; i <= B; ++i) {
    bb[0] = N + 1;
    for (int i = 1; i <= N; ++i) b[i] = 0, bb[i] = 0;
    for (int l = 1, r = 1; r <= N; ++r) {
      --bb[b[a[r]]];
      ++b[a[r]];
      ++bb[b[a[r]]];
      chkmax(mx, b[a[r]]);
      while (l <= r && mx > i) {
        --bb[b[a[l]]];
        --b[a[l]];
        ++bb[b[a[l]]];
        while (!bb[mx]) --mx;
        ++l;
      }
      if (bb[mx] >= 2) chkmax(ans, r - l + 1);
    }
  }
  printf("%d", ans);
  return 0;
}
