#include <bits/stdc++.h>
using namespace std;
long long ac[1000005], c[1000005];
bool mk[1000005];
int cpos(int pos, int i) {
  if (!mk[min(1000005 - 1, pos + i + 1)]) return min(1000005 - 1, pos + i + 1);
  int p = pos;
  for (int j = (1 << 19); j; j >>= 1)
    if (p + j < pos + i + 1 &&
        ac[pos + i + 1] - ac[p + j - 1] < (pos + i + 1 - p - j + 1))
      p += j;
  return p;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m, k, x;
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    cin >> x;
    mk[x] = 1;
  }
  if (mk[0]) {
    cout << (-1) << '\n';
    return 0;
  }
  for (int i = 0; i < k; i++) cin >> c[i];
  ac[0] = mk[0];
  for (int i = 1; i < n; i++) ac[i] = ac[i - 1] + mk[i];
  long long res = 1e18;
  for (int i = 0; i < k; i++) {
    long long cant = 0, pos = 0;
    while (pos < n) {
      int xxx = cpos(pos, i) - pos;
      if (xxx == 0) {
        cant = -1;
        break;
      }
      pos += xxx;
      cant++;
    }
    if (cant != -1) res = min(res, cant * c[i]);
  }
  if (res == 1e18) res = -1;
  cout << (res) << '\n';
  return 0;
}
