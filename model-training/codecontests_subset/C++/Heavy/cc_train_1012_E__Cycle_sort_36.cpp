#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int a[N];
int b[N], t[N], nt[N], u;
vector<int> ans[N];
int top;
int NT(int x) {
  while (nt[x] < t[x + 1] && a[nt[x]] == x) ++nt[x];
  return nt[x];
}
void dfs(int x) {
  while (NT(x) < t[x + 1]) {
    int now = nt[x]++;
    dfs(a[now]);
    ans[top].push_back(now);
  }
}
int main() {
  int n, s;
  cin >> n >> s;
  for (int i = 1; i <= n; ++i) scanf("%d", a + i);
  for (int i = 1; i <= n; ++i) b[i] = a[i];
  sort(b + 1, b + n + 1);
  for (int i = 1; i <= n; ++i)
    if (b[i] != b[u]) {
      ++u;
      t[u] = i;
      b[u] = b[i];
    }
  t[u + 1] = n + 1;
  for (int i = 1; i <= n; ++i) a[i] = lower_bound(b + 1, b + u + 1, a[i]) - b;
  for (int i = 1; i <= u; ++i) nt[i] = t[i];
  for (int i = 1; i <= u; ++i)
    if (NT(i) < t[i + 1]) {
      ++top;
      dfs(i);
      s -= ans[top].size();
      reverse(ans[top].begin(), ans[top].end());
    }
  if (s < 0)
    puts("-1");
  else {
    s = min(s, top);
    if (s < 2) {
      printf("%d\n", top);
      for (int i = 1; i <= top; ++i) {
        printf("%d\n", (int)ans[i].size());
        for (auto x : ans[i]) printf("%d ", x);
        puts("");
      }
    } else {
      printf("%d\n", top - s + 2);
      int sum = 0;
      for (int i = 1; i <= s; ++i) sum += ans[i].size();
      printf("%d\n", sum);
      for (int i = 1; i <= s; ++i)
        for (auto x : ans[i]) printf("%d ", x);
      puts("");
      printf("%d\n", s);
      for (int i = s; i >= 1; --i) printf("%d ", ans[i][0]);
      puts("");
      for (int i = s + 1; i <= top; ++i) {
        printf("%d\n", (int)ans[i].size());
        for (auto x : ans[i]) printf("%d ", x);
        puts("");
      }
    }
  }
}
