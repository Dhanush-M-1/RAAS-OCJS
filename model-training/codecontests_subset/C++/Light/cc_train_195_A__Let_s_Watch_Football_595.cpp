#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, c;
  long long b;
  cin >> a >> b >> c;
  double x = a * c;
  x = x / b;
  long long ans = ceil(x) - c;
  cout << ans << endl;
}
