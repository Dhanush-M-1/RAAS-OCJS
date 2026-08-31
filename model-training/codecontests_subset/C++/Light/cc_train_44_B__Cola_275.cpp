#include <bits/stdc++.h>
using namespace std;
const long long M = 1e5 + 1, MOD = 1e9 + 7;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  a = a * 0.5;
  int possible_way = 0;
  for (int i = 0; i <= c; i++) {
    int need = 2 * i;
    for (int j = 0; j <= b; j++) {
      int need1 = need + j;
      if (need1 > n)
        break;
      else if (n - need1 <= a) {
        possible_way++;
      }
    }
  }
  cout << possible_way << endl;
  return 0;
}
