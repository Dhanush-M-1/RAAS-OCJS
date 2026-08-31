#include <bits/stdc++.h>
using namespace std;
vector<int> graph[200002];
int visited[200002], sub[200002];
int subsize(int root) {
  visited[root] = 1;
  for (int child : graph[root]) {
    if (!visited[child]) sub[root] += subsize(child);
  }
  return sub[root];
}
void destroy(int root, int par) {
  for (int child : graph[root]) {
    if (child != par && (sub[child] % 2 == 0)) destroy(child, root);
  }
  printf("%d\n", root);
  for (int child : graph[root]) {
    if (child != par && (sub[child] & 1)) destroy(child, root);
  }
}
int main() {
  for (int i = 0; i < 200002; i++) sub[i] = 1;
  int n, x;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &x);
    if (x) {
      graph[x].push_back(i);
      graph[i].push_back(x);
    }
  }
  if (n % 2 == 0)
    printf("NO");
  else {
    subsize(1);
    printf("YES\n");
    destroy(1, 0);
  }
  return 0;
}
