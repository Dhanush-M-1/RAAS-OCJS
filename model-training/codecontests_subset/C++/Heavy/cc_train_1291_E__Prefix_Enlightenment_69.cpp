#include <bits/stdc++.h>
using ll = long long;
using namespace std;
const int maxn = 6e5 + 5;
int fa[maxn], val[maxn], ans;
vector<int> V[maxn];
int n, k;
string s;
void init() {
  for (int i = 0; i < maxn; ++i) fa[i] = i;
}
int getfa(int x) { return x == fa[x] ? x : fa[x] = getfa(fa[x]); }
void merge(int x, int y) {
  int fx = getfa(x), fy = getfa(y);
  if (fx != fy) {
    fa[fx] = fy;
    val[fy] += val[fx];
  }
}
int va(int x) { return min(val[getfa(x)], val[getfa(x + k)]); }
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> k >> s;
  for (int i = 1; i <= k; ++i) {
    int c;
    cin >> c;
    for (int j = 1; j <= c; ++j) {
      int tmp;
      cin >> tmp;
      V[tmp].push_back(i);
    }
  }
  for (int i = 1; i <= 2 * k; ++i) fa[i] = i, val[i] = i > k;
  fa[2 * k + 1] = 2 * k + 1, val[2 * k + 1] = 0x3f3f3f3f;
  for (int i = 1; i <= n; ++i) {
    if (V[i].size() == 1) {
      int x = V[i][0] + (s[i - 1] == '1') * k;
      ans -= va(V[i][0]);
      merge(x, k * 2 + 1);
      ans += va(V[i][0]);
    } else if (V[i].size() == 2) {
      int x = V[i][0], y = V[i][1];
      if (s[i - 1] == '0') {
        if (getfa(x) != getfa(y + k)) {
          ans -= va(x) + va(y);
          merge(x, y + k);
          merge(x + k, y);
          ans += va(x);
        }
      } else {
        if (getfa(x) != getfa(y)) {
          ans -= va(x) + va(y);
          merge(x, y);
          merge(x + k, y + k);
          ans += va(x);
        }
      }
    }
    cout << ans << endl;
  }
  return 0;
}
