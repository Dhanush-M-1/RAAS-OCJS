#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:64000000")
using namespace std;
const double PI = 6.283185307179586476925286766559;
const int MAXN = 200011;
int n, m;
int mas[MAXN];
void solve() {
  cin >> m >> n;
  for (int i = 0; i < m; ++i) {
    int t;
    cin >> t;
    for (int j = 0; j < t; ++j) {
      int k;
      cin >> k;
      mas[k] = 1;
    }
  }
  for (int i = 1; i <= n; ++i) {
    if (!mas[i]) {
      cout << "NO";
      return;
    }
  }
  cout << "YES";
}
int main() {
  srand(time(0));
  solve();
  return 0;
}
