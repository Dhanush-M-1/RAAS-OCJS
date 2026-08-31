#include <bits/stdc++.h>
using namespace std;
const int MAX = 2e5 + 1;
int n, m, k, ans;
int du[MAX], X[MAX], Y[MAX], Ans[MAX];
vector<int> ve[MAX];
bool use[MAX];
void work(int x) {
  queue<int> qu;
  qu.push(x), use[x] = 1, --ans;
  while (!qu.empty()) {
    int tt = qu.front();
    qu.pop();
    for (int i = 0; i < ve[tt].size(); ++i) {
      int y = ve[tt][i];
      if (use[y]) continue;
      --du[y];
      if (du[y] < k) --ans, use[y] = 1, qu.push(y);
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  ans = n;
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d", &X[i], &Y[i]);
    ++du[X[i]], ++du[Y[i]], ve[X[i]].push_back(Y[i]), ve[Y[i]].push_back(X[i]);
  }
  for (int i = 1; i <= n; ++i)
    if (du[i] < k && !use[i]) work(i);
  Ans[m] = ans;
  for (int i = m; i >= 1; --i) {
    if (!use[Y[i]]) --du[X[i]];
    if (!use[X[i]]) --du[Y[i]];
    ve[X[i]].pop_back(), ve[Y[i]].pop_back();
    if (du[X[i]] < k && !use[X[i]]) work(X[i]);
    if (du[Y[i]] < k && !use[Y[i]]) work(Y[i]);
    Ans[i - 1] = ans;
  }
  for (int i = 1; i <= m; ++i) printf("%d\n", Ans[i]);
  return 0;
}
