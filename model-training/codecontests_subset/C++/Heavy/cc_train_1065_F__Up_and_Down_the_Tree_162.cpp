#include <bits/stdc++.h>
using namespace std;
const int N = 1000005;
int n, k, D, q[N], S[N], sz[N], ans;
vector<int> e[N];
void dfs1(int x) {
  q[++*q] = x;
  if (!e[x].size()) {
    ++S[x];
    ++sz[x];
    if (*q > k) --S[q[*q - k]];
  }
  for (auto i : e[x]) {
    dfs1(i);
    S[x] += S[i];
    if (S[i]) {
      sz[x] += sz[i];
      sz[i] = 0;
    }
  }
  --*q;
}
void dfs2(int x, int s) {
  ans = max(ans, s += sz[x]);
  for (auto i : e[x]) dfs2(i, s);
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = (int)(2); i <= (int)(n); i++) {
    int x;
    scanf("%d", &x);
    e[x].push_back(i);
  }
  dfs1(1);
  dfs2(1, 0);
  cout << ans << endl;
}
