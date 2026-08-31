#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3fffffff;
const int PRIME = 999983;
const int MOD = 10007;
const int MULTI = 1000000007;
const double EPS = 1e-9;
long long n;
int bit[20], m;
bool tag;
vector<pair<int, int> > d[10], ans;
void dfs(int p, int x) {
  if (p == m) {
    if (!x) {
      tag = false;
      long long res[6] = {0}, base = 1;
      for (int i = 0; i < ans.size(); i++, base *= 10) {
        int a = ans[i].first, b = ans[i].second;
        for (int j = 0; j < 6; j++) {
          if (a)
            res[j] += 4 * base, a--;
          else if (b)
            res[j] += 7 * base, b--;
        }
      }
      for (int i = 0; i < 6; i++) printf("%I64d ", res[i]);
      puts("");
    }
    return;
  }
  int y = (bit[p] - x + 10) % 10;
  for (int i = 0; tag && i < d[y].size(); i++) {
    ans.push_back(d[y][i]);
    int a = d[y][i].first, b = d[y][i].second;
    dfs(p + 1, (x + a * 4 + b * 7) / 10);
    ans.pop_back();
  }
}
int main() {
  int re;
  for (int i = 0; i <= 6; i++)
    for (int j = 0; i + j <= 6; j++)
      d[(i * 4 + j * 7) % 10].push_back((pair<int, int>){i, j});
  scanf("%d", &re);
  while (re--) {
    scanf("%I64d", &n);
    m = 0;
    while (n) bit[m++] = n % 10, n /= 10;
    tag = true;
    dfs(0, 0);
    if (tag) puts("-1");
  }
  return 0;
}
