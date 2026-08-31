#include <bits/stdc++.h>
using namespace std;
int main() {
  string abc, abc1, abc2, ar[1005], br[1005];
  long long n, a, b, i, j, k, c;
  cin >> abc >> abc1;
  cin >> n;
  ar[0] = abc;
  br[0] = abc1;
  for (i = 1; i <= n; i++) {
    cin >> abc >> abc2;
    if (abc == abc1) {
      ar[i] = ar[i - 1];
      br[i] = abc2;
      abc1 = abc2;
      continue;
    }
    ar[i] = abc2;
    br[i] = abc1;
  }
  for (i = 0; i <= n; i++) cout << ar[i] << " " << br[i] << endl;
  return 0;
}
