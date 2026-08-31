#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<vector<int> > books(n);
  vector<bool> ch(n, false);
  vector<int> ws(n);
  for (int i = 0; i < n; i++) cin >> ws[i];
  long long sum = 0;
  int a;
  for (int i = 0; i < m; i++) {
    cin >> a;
    a--;
    if (!ch[a]) {
      ch[a] = true;
      for (int j = 0; j < books[a].size(); j++) {
        sum += ws[books[a][j]];
      }
      for (int j = 0; j < n; j++) {
        if (j == a) continue;
        books[j].push_back(a);
      }
    } else {
      for (int j = 0; j < books[a].size(); j++) {
        sum += ws[books[a][j]];
        books[books[a][j]].push_back(a);
      }
    }
    books[a].clear();
  }
  cout << sum;
  return 0;
}
