#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long int a, b, n, x;
    cin >> a >> b >> n;
    if (n < a || n > b)
      cout << n << endl;
    else {
      x = b / n;
      cout << n * x + n << endl;
    }
  }
}
