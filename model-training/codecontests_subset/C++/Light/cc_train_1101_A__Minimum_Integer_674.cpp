#include <bits/stdc++.h>
using namespace std;
int q;
int main() {
  cin >> q;
  while (q--) {
    int a, b, n;
    cin >> a >> b >> n;
    if (n < a || n > b)
      cout << n << endl;
    else {
      int t = b / n;
      cout << n * (t + 1) << endl;
    }
  }
  return 0;
}
