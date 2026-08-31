#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m;
  cin >> n >> m;
  int ans = 0;
  while (n--) {
    int j;
    cin >> j;
    if (m % j == 0 && j > ans) ans = j;
  }
  cout << m / ans;
  return 0;
}
