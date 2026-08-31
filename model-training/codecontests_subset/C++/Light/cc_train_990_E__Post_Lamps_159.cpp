#include <bits/stdc++.h>
using namespace std;
vector<long long> blk;
long long cvr[1000009], cost[1000009], n, m, k, i, x, kl, minc, last[1000009];
bool pos[1000009];
bool chk = true;
long long quant(long long siz) {
  long long pp = 0, cnt = 1;
  while (pp + siz < n) {
    if (last[pp + siz] <= pp) return -1;
    pp = last[pp + siz];
    cnt++;
  }
  return cnt;
}
int main() {
  cin >> n >> m >> k;
  for (i = 0; i < n; i++) pos[i] = true;
  for (i = 0; i < m; i++) {
    scanf("%lld", &x);
    if (x == 0) chk = false;
    blk.push_back(x);
    pos[x] = false;
  }
  for (i = 0; i < k; i++) {
    scanf("%lld", &cost[i]);
  }
  if (chk) {
    for (i = 0; i < n; i++) {
      if (pos[i])
        last[i] = i;
      else if (i)
        last[i] = last[i - 1];
    }
    minc = 1000000000000000000;
    for (i = 0; i < k; i++) {
      kl = quant(i + 1);
      if (kl == -1) continue;
      minc = min(minc, kl * cost[i]);
    }
  }
  if (chk && minc != 1000000000000000000)
    cout << minc << endl;
  else
    cout << -1 << endl;
  return 0;
}
