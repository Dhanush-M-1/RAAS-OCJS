#include <bits/stdc++.h>
using namespace std;
bool dp[1005][1005];
vector<int> v;
int b[1005], A[1005];
int Find(int A[], int x) {
  int root = x, tmp;
  while (A[root] >= 0) root = A[root];
  while (x != root) {
    tmp = x;
    x = A[x];
    A[tmp] = root;
  }
  return root;
}
void Union(int A[], int a, int b) {
  int x = Find(A, a), y = Find(A, b), tmp;
  if (x != y) {
    if (A[x] > A[y]) {
      tmp = x;
      x = y;
      y = tmp;
    }
    A[x] += A[y];
    A[y] = x;
  }
}
int main() {
  int n, x, i, j, c = 1, r;
  memset(A, -1, sizeof A);
  cin >> n >> x;
  for (i = 1; i <= n; i++) cin >> b[i];
  i = x;
  while (b[i]) {
    c++;
    i = b[i];
  }
  for (i = 1; i <= n; i++)
    if (b[i]) Union(A, i, b[i]);
  r = Find(A, x);
  for (i = 1; i <= n; i++)
    if (A[i] < 0 && i != r) v.push_back(-A[i]);
  dp[0][0] = true;
  for (i = 1; i <= v.size(); i++)
    for (j = 0; j <= n; j++)
      if (v[i - 1] > j)
        dp[i][j] = dp[i - 1][j];
      else
        dp[i][j] = dp[i - 1][j] | dp[i - 1][j - v[i - 1]];
  for (i = 0; i <= n; i++)
    if (dp[v.size()][i]) cout << i + c << endl;
  return 0;
}
