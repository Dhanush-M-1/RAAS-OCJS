#include <bits/stdc++.h>
using namespace std;
int nextInt() {
  int x;
  scanf("%d", &x);
  return x;
}
string nextString() {
  string s;
  cin >> s;
  return s;
}
const int MAXN = 2e5;
vector<int> G[MAXN + 10];
int num[MAXN + 10];
int f[MAXN + 10];
vector<int> order;
void dfs(int v) {
  for (auto u : G[v]) {
    dfs(u);
  }
  order.push_back(v);
}
int main() {
  int n = nextInt();
  int root = -1;
  for (int i = (1); i <= (n); ++i) {
    int x = nextInt();
    if (x == 0)
      root = i;
    else
      num[i]++, num[x]++;
    G[x].push_back(i);
    f[i] = x;
  }
  dfs(root);
  vector<int> ans0;
  vector<int> ans1;
  for (auto i : order) {
    if (num[i] & 1) {
      if (i == root) {
        cout << "NO\n";
        return 0;
      }
      ans1.push_back(i);
    } else {
      num[f[i]]--;
      ans0.push_back(i);
    }
  }
  reverse(begin(ans1), end(ans1));
  ans0.insert(ans0.end(), begin(ans1), end(ans1));
  cout << "YES\n";
  for (auto i : ans0) {
    cout << i << endl;
  }
}
