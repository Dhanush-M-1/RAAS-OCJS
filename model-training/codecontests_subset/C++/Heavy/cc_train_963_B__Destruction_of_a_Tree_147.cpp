#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cerr << name << " : " << arg1 << std::endl;
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
const int N = 200005;
int tree[N];
vector<int> con[N];
int calc_parity(int s = 1, int p = 0) {
  tree[s] = 1;
  for (int v : con[s])
    if (v != p) tree[s] ^= calc_parity(v, s);
  return tree[s];
}
void dfs(int s = 1, int p = 0) {
  for (int v : con[s])
    if (v != p && tree[v] == 0) dfs(v, s);
  printf("%d\n", s);
  for (int v : con[s])
    if (v != p && tree[v] == 1) dfs(v, s);
}
int main() {
  int n;
  scanf("%d", &(n));
  for (int i = 1; i <= n; i++) {
    int p;
    scanf("%d", &(p));
    if (p) {
      con[i].push_back(p);
      con[p].push_back(i);
    }
  }
  if (n % 2 == 0) {
    printf("NO\n");
    return 0;
  }
  printf("YES\n");
  calc_parity();
  dfs();
}
