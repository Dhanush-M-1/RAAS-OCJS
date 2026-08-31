#include <bits/stdc++.h>
using namespace std;
bool arr[100];
int n, m, k, k1;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> k;
    for (int y = 1; y <= k; y++) {
      cin >> k1;
      arr[k1] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (!arr[i]) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  return 0;
}
