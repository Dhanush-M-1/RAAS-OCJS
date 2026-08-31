#include <bits/stdc++.h>
using namespace std;
int n, a, b;
vector<int> adj[100005];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = (int)1; i <= (int)n - 1; i++) {
    cin >> a >> b;
    adj[a].push_back(b);
    adj[b].push_back(a);
  }
  for (int i = (int)1; i <= (int)n; i++)
    if (adj[i].size() == 2) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
}
