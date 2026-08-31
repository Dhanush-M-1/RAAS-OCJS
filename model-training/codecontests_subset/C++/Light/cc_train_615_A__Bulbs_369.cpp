#include <bits/stdc++.h>
using namespace std;
int n, m;
int x, k, check[1000], i;
int main() {
  cin >> n >> m;
  while (n--) {
    cin >> k;
    for (i = 1; i <= k; i++) {
      cin >> x;
      check[x] = 1;
    }
  }
  for (i = 1; i <= m; i++)
    if (check[i] == 0) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
}
