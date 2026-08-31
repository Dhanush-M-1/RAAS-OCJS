#include <bits/stdc++.h>
using namespace std;
vector<int> graf[200005], stek;
bool mark[200005];
int root;
void dfsd(int s) {
  if (mark[s]) return;
  mark[s] = true;
  stek.push_back(s);
  for (int i = 0; i < graf[s].size(); i++) dfsd(graf[s][i]);
}
void dfs(int s) {
  int deg = 0;
  if (s != root) deg++;
  for (int i = 0; i < graf[s].size(); i++) {
    dfs(graf[s][i]);
    if (!mark[graf[s][i]]) deg++;
  }
  if (deg % 2 == 0) dfsd(s);
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int t;
    scanf("%d", &t);
    graf[t].push_back(i);
    if (t == 0) root = i;
  }
  dfs(root);
  if (stek.size() < n)
    printf("NO");
  else {
    printf("YES\n");
    for (int i = 0; i < n; i++) printf("%d\n", stek[i]);
  }
}
