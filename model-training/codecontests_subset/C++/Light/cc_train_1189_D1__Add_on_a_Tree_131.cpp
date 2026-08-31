#include <bits/stdc++.h>
using namespace std;
vector<long long> tree[500500];
long long num[500500], fine = 0, n;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (int i = 1; i < n; i++) {
    long long u, v;
    cin >> u >> v;
    tree[u].push_back(v);
    tree[v].push_back(u);
  }
  for (int i = 1; i <= n; i++)
    if (tree[i].size() == 2) return cout << "NO", 0;
  cout << "YES";
}
