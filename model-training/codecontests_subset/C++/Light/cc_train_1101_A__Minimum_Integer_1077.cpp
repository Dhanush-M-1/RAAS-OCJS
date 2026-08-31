#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t, a, b, c, i;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    if (c < a)
      cout << c << endl;
    else {
      i = (b / c) + 1;
      cout << i * c << endl;
    }
  }
}
