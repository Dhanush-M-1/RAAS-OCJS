#include <bits/stdc++.h>
using namespace std;
const int maxn = 1100;
int son[maxn];
bool flag;
bool v[maxn];
bool f[maxn];
int before;
int tot, n, m, x;
void dfs(int now) {
  if (now == m) {
    before = tot + 1;
    flag = true;
  }
  ++tot;
  if (son[now]) dfs(son[now]);
}
vector<int> num;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= (n); ++i) {
    scanf("%d", &x);
    if (x) {
      son[x] = i;
      v[i] = true;
    }
  }
  for (int i = 1; i <= (n); ++i)
    if (!v[i]) {
      tot = 0;
      flag = false;
      dfs(i);
      if (!flag) num.push_back(tot);
    }
  f[0] = true;
  for (int i = 0; i < num.size(); ++i)
    for (int j = n; j >= num[i]; --j)
      if (f[j - num[i]]) f[j] = true;
  for (int i = 0; i <= n; ++i)
    if (f[i]) cout << before + i << endl;
  return 0;
}
