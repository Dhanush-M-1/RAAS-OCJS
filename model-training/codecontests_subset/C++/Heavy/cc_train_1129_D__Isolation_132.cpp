#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 5, B = 350, Mod = 998244353;
int n, lim, siz, block_cnt, cnt[maxn], a[maxn], b[maxn], sum_b[1005],
    sum_f[1005][1005], f[maxn];
vector<int> pos[maxn];
void cal(int w) {
  memset(sum_f[w], 0, sizeof sum_f[w]);
  int tmp = 0;
  for (int i = w * siz; i > w * siz - siz; i--)
    tmp += b[i], sum_f[w][tmp + B] = (sum_f[w][tmp + B] + f[i - 1]) % Mod;
  for (int i = -siz + 1; i <= siz; i++)
    sum_f[w][i + B] = (sum_f[w][i + B] + sum_f[w][i - 1 + B]) % Mod;
  sum_b[w] = tmp;
}
int main() {
  f[0] = 1;
  cin >> n >> lim;
  for (int i = 1; i <= n; i++) cin >> a[i], pos[a[i]].push_back(i);
  siz = sqrt(n);
  block_cnt = (n - 1) / siz + 1;
  for (int i = 1; i <= block_cnt; i++) {
    for (int j = i * siz - siz + 1; j <= min(i * siz, n); j++) {
      if (cnt[a[j]] == 1) {
        int p = pos[a[j]][cnt[a[j]] - 1];
        b[p] = -1;
        if (p <= i * siz - siz) cal((p - 1) / siz + 1);
      } else if (cnt[a[j]] > 1) {
        int p1 = pos[a[j]][cnt[a[j]] - 2], p2 = pos[a[j]][cnt[a[j]] - 1];
        b[p1] = 0;
        b[p2] = -1;
        if (p1 <= i * siz - siz) cal((p1 - 1) / siz + 1);
        if (p2 <= i * siz - siz) cal((p2 - 1) / siz + 1);
      }
      b[j] = 1;
      cnt[a[j]]++;
      int tmp = 0;
      for (int k = j; k > i * siz - siz; k--) {
        tmp += b[k];
        if (tmp <= lim) f[j] = (f[j] + f[k - 1]) % Mod;
      }
      for (int k = i - 1; k; k--) {
        if (lim - tmp >= -siz)
          f[j] = (f[j] + sum_f[k][min(lim - tmp, siz) + B]) % Mod;
        tmp += sum_b[k];
      }
    }
    if (i < block_cnt) cal(i);
  }
  cout << f[n] << '\n';
  return 0;
}
