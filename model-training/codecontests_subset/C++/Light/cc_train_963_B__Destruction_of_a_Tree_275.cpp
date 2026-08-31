#include <bits/stdc++.h>
using namespace std;
const int N = 200010;
int ne[N << 1], fi[N], b[N << 1], d[N], n, k, rt;
vector<int> s[N], ans;
void add(int x, int y) {
  ne[++k] = fi[x];
  b[fi[x] = k] = y;
  ++d[x];
}
void era(int x) {
  for (vector<int>::iterator i = s[x].begin(); i != s[x].end(); ++i)
    if (*i == x)
      ans.push_back(x);
    else
      era(*i);
  s[x].clear();
}
void fst(int x, int fa) {
  s[x].push_back(x);
  for (int j = fi[x]; j; j = ne[j])
    if (b[j] != fa) {
      fst(b[j], x);
      if (s[b[j]].size()) s[x].push_back(b[j]);
    }
  if (~d[x] & 1) {
    --d[fa];
    era(x);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    int x;
    scanf("%d", &x);
    if (x == 0)
      rt = i;
    else
      add(x, i), add(i, x);
  }
  fst(rt, 0);
  if ((signed)ans.size() != n) return puts("NO"), 0;
  puts("YES");
  for (vector<int>::iterator i = ans.begin(); i != ans.end(); ++i)
    printf("%d\n", *i);
}
