#include <bits/stdc++.h>
using namespace std;
long long n, t, a[50006];
int main() {
  cin >> t;
  while (t--) {
    cin >> n;
    for (int i = 1; i <= n; i++) {
      cin >> a[i];
    }
    if ((a[2] + a[1]) <= a[n]) {
      cout << "1 2 " << n << endl;
      ;
    } else
      cout << "-1" << endl;
  }
  return 0;
}
