#include <bits/stdc++.h>
using namespace std;
int main() {
  long long q;
  cin >> q;
  while (q--) {
    long long a, b, d;
    cin >> a >> b >> d;
    long long temp = a / d;
    long long temp2 = b / d;
    if (d < a || d > b) {
      cout << d << endl;
    } else {
      long long num1 = (temp2 + 1) * d;
      cout << num1 << endl;
    }
  }
}
