#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, l = 0, aiz = 0;
  cin >> a >> b;
  while (true) {
    l += a;
    if (a == 0) {
      cout << l;
      break;
    }
    aiz += a;
    a = aiz / b;
    aiz %= b;
  }
  return 0;
}
