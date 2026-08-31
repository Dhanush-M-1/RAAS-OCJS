#include <bits/stdc++.h>
using namespace std;
const int N = 1000010;
int main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  long long n;
  cin >> n;
  while (n--) {
    long long l, r, d;
    cin >> l >> r >> d;
    long long q = (l % d == 0 ? d : l % d), p = (d - r % d);
    if (l - q > 0)
      cout << d;
    else
      cout << r + p;
    cout << '\n';
  }
}
