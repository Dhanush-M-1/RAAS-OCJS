#include <bits/stdc++.h>
using namespace std;
long long int n;
vector<long long int> G[200020];
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int x, y;
    cin >> x >> y;
    G[x].push_back(y);
    G[y].push_back(x);
  }
  for (int i = 1; i <= n; i++) {
    if (G[i].size() == 2) return cout << "NO", 0;
  }
  cout << "YES";
}
