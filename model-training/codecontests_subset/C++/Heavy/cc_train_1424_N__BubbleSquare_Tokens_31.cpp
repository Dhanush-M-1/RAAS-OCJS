#include <bits/stdc++.h>
using namespace std;
int n, m, x[12503], y[1000003], val[12503], lst[1000003];
vector<int> v[12503], g[12503], A, B, V;
int main() {
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    a--;
    b--;
    val[a]++;
    val[b]++;
    v[max(a, b)].push_back(min(a, b));
    g[max(a, b)].push_back(i);
    y[i] = 1;
    A.push_back(a + 1);
    B.push_back(b + 1);
  }
  for (int i = 0; i < 1000003; i++) lst[i] = -1;
  for (int i = 0; i < n; i++) {
    int nowval = val[i];
    for (int j = 0; j < v[i].size(); j++) {
      if (x[v[i][j]] == 0) {
        x[v[i][j]]++;
        y[g[i][j]]--;
        nowval--;
      }
      lst[val[v[i][j]]] = i;
    }
    for (int j = 0; j <= v[i].size(); j++)
      if (lst[nowval + j] != i) {
        for (int k = 0; k < j; k++) {
          x[v[i][k]]--;
          y[g[i][k]]++;
        }
        nowval += j;
        break;
      }
    val[i] = nowval;
  }
  for (int i = 0; i < n; i++)
    if (x[i]) V.push_back(i + 1);
  cout << V.size() << endl;
  for (int i = 0; i < V.size(); i++) printf("%d ", V[i]);
  if (V.size()) cout << endl;
  for (int i = 0; i < m; i++) printf("%d %d %d\n", A[i], B[i], y[i]);
}
