#include <bits/stdc++.h>
using namespace std;
const int inf = 2e9;
const int mod = 1e9 + 7;
const int N = 1e5 + 228;
const double PI = acos(-1);
const double eps = 1e-9;
int main() {
  ios::sync_with_stdio(0);
  int n, m;
  cin >> n >> m;
  vector<bool> a(m + 1);
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    int x;
    while (k--) {
      cin >> x;
      a[x] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (!a[i]) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
  return 0;
}
