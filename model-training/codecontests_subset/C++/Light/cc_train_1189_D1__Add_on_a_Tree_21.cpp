#include <bits/stdc++.h>
using namespace std;
int n, m, i, j, p, q;
vector<int> G[100005];
int main() {
  cin >> n;
  for (i = 0; i < n - 1; i++) {
    cin >> p >> q;
    G[p - 1].push_back(q - 1);
    G[q - 1].push_back(p - 1);
  }
  bool flag = false;
  for (i = 0; i < n; i++) {
    if (G[i].size() == 2) {
      flag = true;
      break;
    }
  }
  if (!flag)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
}
