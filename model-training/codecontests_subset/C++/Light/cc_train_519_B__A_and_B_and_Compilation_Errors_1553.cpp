#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  cin >> n;
  long long int sa = 0, sb = 0, sc = 0;
  long long int a, b, c;
  for (int i = 0; i < n; i++) {
    cin >> a;
    sa += a;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b;
    sb += b;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c;
    sc += c;
  }
  long long int res1 = sa - sb, res2 = sb - sc;
  cout << res1 << '\n' << res2;
  return 0;
}
