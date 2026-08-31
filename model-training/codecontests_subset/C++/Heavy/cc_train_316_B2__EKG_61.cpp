#include <bits/stdc++.h>
using namespace std;
int maz[1005][1005];
bool vist[5005];
vector<int> vec, ans;
int block[1005], f[1500];
int n, x;
int pos, numb;
bool flag;
int tot;
void dfs(int bb, int cur) {
  vist[cur] = 1;
  tot++;
  if (cur == x) {
    pos = tot;
    numb = bb;
    flag = 1;
  }
  for (int i = (1); i <= (n); i++) {
    if (!vist[i] && maz[cur][i]) {
      dfs(bb, i);
    }
  }
}
int main() {
  memset(maz, 0, sizeof(maz));
  memset(vist, 0, sizeof(vist));
  memset(block, 0, sizeof(block));
  vec.clear();
  int a;
  scanf("%d%d", &n, &x);
  for (int i = (1); i <= (n); i++) {
    scanf("%d", &a);
    if (a == 0)
      vec.push_back(i);
    else
      maz[a][i] = 1;
  }
  int sz = vec.size();
  for (int i = 0; i < sz; i++) {
    flag = 0;
    tot = 0;
    dfs(i, vec[i]);
    if (!flag) block[i] = tot;
  }
  sort(block, block + sz);
  memset(f, 0, sizeof(f));
  for (int i = (1); i <= (sz - 1); i++) {
    for (int j = n; j >= block[i]; j--) {
      if (f[j] < f[j - block[i]] + block[i]) f[j] = f[j - block[i]] + block[i];
    }
  }
  for (int i = (0); i <= (n); i++) {
    if (f[i] == i) {
      printf("%d\n", pos + i);
    }
  }
  return 0;
}
