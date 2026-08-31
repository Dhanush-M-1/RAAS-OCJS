#include <bits/stdc++.h>
using namespace std;
long long br[200002];
long long n, x, y;
int main() {
  cin >> n;
  for (long long i = 1; i < n; i++) {
    cin >> x >> y;
    br[x]++;
    br[y]++;
  }
  for (long long i = 1; i <= n; i++) {
    if (br[i] == 2) {
      cout << "NO\n";
      return 0;
    }
  }
  cout << "YES\n";
  return 0;
}
