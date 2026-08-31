#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
int n, m, t, k;
int d[((int)1e5 + 5)];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    if (c < a || c > b)
      cout << c << endl;
    else
      cout << ((b / c) + 1) * c << endl;
  }
}
