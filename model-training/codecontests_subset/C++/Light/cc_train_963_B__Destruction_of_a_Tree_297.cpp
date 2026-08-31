#include <bits/stdc++.h>
using namespace std;
vector<int> Tree[200005], ans;
stack<int> S;
int root, a, x, odw[200005];
bool DFS(int n) {
  odw[n] = true;
  int cnt = 1;
  if (n == root) cnt--;
  for (int i = 0; i < Tree[n].size(); i++)
    if (!odw[Tree[n][i]]) cnt += (int)DFS(Tree[n][i]);
  if (cnt % 2)
    S.push(n);
  else {
    ans.push_back(n);
    return false;
  }
  return true;
}
int main() {
  cin >> a;
  for (int i = 1; i <= a; i++) {
    cin >> x;
    if (!x) {
      root = i;
      continue;
    }
    Tree[i].push_back(x);
    Tree[x].push_back(i);
  }
  if (DFS(root)) {
    cout << "NO";
    return 0;
  }
  cout << "YES\n";
  for (int i = 0; i < ans.size(); i++) cout << ans[i] << "\n";
  while (!S.empty()) {
    cout << S.top() << "\n";
    S.pop();
  }
  return 0;
}
