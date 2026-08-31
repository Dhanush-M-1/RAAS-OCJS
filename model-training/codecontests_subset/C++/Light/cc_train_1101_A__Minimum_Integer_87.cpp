#include <bits/stdc++.h>
using namespace std;
long long q, a, b, d;
int main() {
  cin >> q;
  while (q--) {
    cin >> a >> b >> d;
    if (d < a)
      cout << d << endl;
    else
      cout << ((b / d) + 1) * d << endl;
  }
}
