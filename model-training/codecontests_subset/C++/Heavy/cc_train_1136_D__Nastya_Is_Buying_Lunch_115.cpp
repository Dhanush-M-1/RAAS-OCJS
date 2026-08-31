#include <bits/stdc++.h>
using namespace std;
const int MAX = 3e5 + 5;
int change[MAX], p[MAX];
vector<int> adj[MAX];
int N, M, a, b;
int main(int argc, char** argv) {
  scanf("%d%d", &N, &M);
  for (int i = (1); i <= (N); i++) scanf("%d", &p[i]);
  for (int k = (0); k < (M); k++) {
    scanf("%d%d", &a, &b);
    adj[b].push_back(a);
  }
  int cnt = 0, sz = 1;
  for (int i = (0); i < (adj[p[N]].size()); i++) change[adj[p[N]][i]]++;
  for (int i = (N - 1); i >= (1); i--) {
    if (change[p[i]] == sz)
      cnt++;
    else {
      sz++;
      for (int j = (0); j < (adj[p[i]].size()); j++) change[adj[p[i]][j]]++;
    }
  }
  printf("%d\n", cnt);
  return 0;
}
