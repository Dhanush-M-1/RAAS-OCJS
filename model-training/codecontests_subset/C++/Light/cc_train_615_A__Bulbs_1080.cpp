#include <bits/stdc++.h>
using namespace std;
ifstream fin("universal.in");
ofstream fout("");
int n, m;
set<int> on;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) {
    int aux;
    cin >> aux;
    for (int j = 1, bb; j <= aux; ++j) {
      cin >> bb;
      on.insert(bb);
    }
    if (on.size() == m) {
      cout << "YES\n";
      return 0;
    }
  }
  cout << "NO\n";
  return 0;
}
