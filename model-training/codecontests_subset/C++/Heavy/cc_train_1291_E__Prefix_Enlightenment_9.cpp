#include <bits/stdc++.h>
using namespace std;
const int N = 6e5 + 100;
vector<int> v[N];
int father[N], cnt[N], k;
int Find(int x) { return father[x] = father[x] == x ? x : Find(father[x]); }
void unite(int x, int y) {
  int tx = Find(x);
  int ty = Find(y);
  if (tx == ty) return;
  father[tx] = ty;
  cnt[ty] += cnt[tx];
}
int calc(int x) { return min(cnt[Find(x)], cnt[Find(x + k)]); }
int main() {
  int n, x, m;
  string s;
  cin >> n >> k;
  cin >> s;
  for (int i = 1; i <= k; i++) {
    cin >> m;
    while (m--) {
      cin >> x;
      x--;
      v[x].push_back(i);
    }
    father[i] = i;
    father[i + k] = i + k;
    cnt[i] = 1;
  }
  father[2 * k + 1] = 2 * k + 1;
  cnt[2 * k + 1] = (int)1e9;
  int ans = 0;
  for (int i = 0; i < n; i++) {
    if ((int)v[i].size() == 1) {
      int to = v[i][0] + k * (s[i] == '0');
      ans -= calc(v[i][0]);
      unite(to, 2 * k + 1);
      ans += calc(v[i][0]);
    } else if ((int)v[i].size() == 2) {
      int x = v[i][0];
      int y = v[i][1];
      if (s[i] == '1' && Find(x) != Find(y)) {
        ans -= calc(x) + calc(y);
        unite(x, y);
        unite(x + k, y + k);
        ans += calc(x);
      }
      if (s[i] == '0' && Find(x) != Find(y + k)) {
        ans -= calc(x) + calc(y);
        unite(x, y + k);
        unite(x + k, y);
        ans += calc(x);
      }
    }
    cout << ans << endl;
  }
  return 0;
}
