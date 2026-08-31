#include <bits/stdc++.h>
using namespace std;
long long n, a, b, d;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a >> b >> d;
    if (d < a)
      cout << d << '\n';
    else
      cout << b + (d - b % d) << '\n';
  }
}
