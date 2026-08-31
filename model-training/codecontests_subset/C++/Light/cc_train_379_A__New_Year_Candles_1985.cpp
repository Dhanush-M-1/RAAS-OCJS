#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, ans = 0;
  cin >> a >> b;
  ans = (a * b - 1) / (b - 1);
  cout << ans;
  return 0;
}
