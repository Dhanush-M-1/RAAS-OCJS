#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  int n, m, x, y;
  unordered_set<int> S;
  cin >> n >> m;
  for (register int i = 0; i < (int)n; i++) {
    cin >> x;
    for (register int i = 0; i < (int)x; i++) cin >> y, S.insert(y);
  }
  cout << (S.size() == m ? "YES" : "NO");
}
