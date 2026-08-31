#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);
  ;
  int t;
  cin >> t;
  while (t--) {
    int a[5 * 10000 + 5] = {};
    int n;
    cin >> n;
    for (int i = (0); i < (n); i += (1)) cin >> a[i];
    if (a[0] + a[1] > a[n - 1])
      cout << "-1" << '\n';
    else
      cout << "1 2 " << n << '\n';
  }
  return 0;
}
