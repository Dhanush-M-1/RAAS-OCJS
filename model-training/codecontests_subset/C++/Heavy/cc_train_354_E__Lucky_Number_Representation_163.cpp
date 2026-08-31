#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void chkmin(T &a, T b) {
  if (a > b) a = b;
}
template <class T>
inline void chkmax(T &a, T b) {
  if (a < b) a = b;
}
map<long long, bool> MP;
int deg[10], a[10][10], b[10][10];
int aa[30], bb[30];
bool find(long long x, int k) {
  if (MP.count(x)) return false;
  int i, j;
  if (x == 0) {
    long long ans[10];
    memset(ans, 0, sizeof(ans));
    for (i = k - 1; i >= 0; i--) {
      j = 0;
      while (aa[i]) {
        ans[j] = ans[j] * 10 + 4;
        j++;
        aa[i]--;
      }
      while (bb[i]) {
        ans[j] = ans[j] * 10 + 7;
        j++;
        bb[i]--;
      }
      while (j < 6) {
        ans[j] = ans[j] * 10;
        j++;
      }
    }
    for (i = 0; i < 6; i++) {
      if (i) printf(" ");
      printf("%I64d", ans[i]);
    }
    puts("");
    return true;
  }
  long long xx;
  MP[x] = false;
  j = x % 10;
  for (i = 0; i < deg[j]; i++) {
    aa[k] = a[j][i];
    bb[k] = b[j][i];
    xx = x - aa[k] * 4 - bb[k] * 7;
    if (xx < 0) continue;
    if (find(xx / 10, k + 1)) return true;
  }
  return false;
}
int main() {
  int i, j, k, t, T;
  long long N;
  for (j = 0; j <= 6; j++)
    for (k = 0; k + j <= 6; k++) {
      i = (j * 4 + k * 7) % 10;
      a[i][deg[i]] = j;
      b[i][deg[i]] = k;
      deg[i]++;
    }
  for (scanf("%d", &T); T--;) {
    scanf("%I64d", &N);
    MP.clear();
    if (!find(N, 0)) puts("-1");
  }
  return 0;
}
