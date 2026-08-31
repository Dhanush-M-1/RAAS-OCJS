#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t, a, b, c;
  cin >> t;
  while (t--) {
    long long int count = 0;
    cin >> a >> b >> c;
    while (b != 0 && c >= 2) {
      count += 3;
      b -= 1;
      c -= 2;
    }
    while (a != 0 && b >= 2) {
      count += 3;
      b -= 2;
      a -= 1;
    }
    cout << count << endl;
  }
  return 0;
}
