#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    long long a[n + 1];
    for (int i = 1; i <= n; i++) cin >> a[i];
    if (a[1] + a[2] <= a[n]) {
      cout << "1"
           << " "
           << "2"
           << " " << n << endl;
    } else
      cout << "-1" << endl;
  }
}
