#include <bits/stdc++.h>
using namespace std;
long long n, a, b, k;
const int ms = 2e5 + 17;
const int mod = 1e9 + 9;
vector<int> v[ms];
vector<int> answer;
bool killed[ms];
void kill(int x) {
  killed[x] = true;
  answer.push_back(x);
  for (int i = 0; i < v[x].size(); ++i) {
    int to = v[x][i];
    if (!killed[to]) kill(to);
  }
}
void dfs(int x, bool isRoot) {
  int deg = isRoot ? 0 : 1;
  for (int i = 0; i < v[x].size(); ++i) {
    int to = v[x][i];
    dfs(to, false);
    if (!killed[to]) ++deg;
  }
  if (deg % 2 == 0) kill(x);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, root;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    int x;
    cin >> x;
    if (!x)
      root = i;
    else
      v[x].push_back(i);
  }
  dfs(root, 1);
  if (answer.size() < n)
    cout << "NO\n";
  else {
    cout << "YES\n";
    for (int i = 0; i < n; ++i) cout << answer[i] << '\n';
  }
}
