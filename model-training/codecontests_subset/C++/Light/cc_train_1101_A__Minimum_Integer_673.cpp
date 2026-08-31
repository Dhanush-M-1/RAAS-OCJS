#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long a, b, d;
    cin >> a >> b >> d;
    if (d < a)
      cout << d << endl;
    else {
      cout << b + d - (b % d) << endl;
    }
  }
}
