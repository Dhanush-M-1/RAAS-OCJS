#include <bits/stdc++.h>
using namespace std;
const int DIM = 1005;
bitset<DIM> oki;
int val[DIM], nxt[DIM];
int main(void) {
  ios ::sync_with_stdio(false);
  cin.tie();
  cout.tie();
  int n, m, ans = 0;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) cin >> val[i], nxt[i] = -1;
  for (int i = 1; i <= m; ++i) {
    int x;
    cin >> x;
    for (int j = 1; j <= n; ++j)
      if (nxt[x] < nxt[j]) ans += val[j];
    nxt[x] = i;
  }
  cout << ans << endl;
  return 0;
}
