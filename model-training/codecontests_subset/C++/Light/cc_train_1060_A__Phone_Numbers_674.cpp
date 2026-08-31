#include <bits/stdc++.h>
using namespace std;
int n, nk;
char k;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> k;
    if (k == '8') nk++;
  }
  cout << min(nk, n / 11) << endl;
  return 0;
}
