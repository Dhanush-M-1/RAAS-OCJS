#include <bits/stdc++.h>
using namespace std;
int n, m, a, d;
vector<int> q[110];
pair<int, int> s[110];
bool mark[110];
bool bl = false;
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> a;
    s[i] = {a, i};
    for (int j = 0; j < a; j++) {
      cin >> d;
      q[i].push_back(d);
    }
  }
  sort(s, s + n);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < q[s[i].second].size(); j++) mark[q[s[i].second][j]] = 1;
  }
  bl = true;
  for (int j = 1; j <= m; j++)
    if (!mark[j]) bl = false;
  if (bl) return cout << "YES" << endl, 0;
  cout << "NO" << endl;
  return 0;
}
