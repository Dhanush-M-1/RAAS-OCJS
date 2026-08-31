#include <bits/stdc++.h>
const double pi = 4.0 * atan(1.0);
const double e = exp(1.0);
using namespace std;
const int N = 3e6 + 5;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  while (n--) {
    long long a, b, c;
    cin >> a >> b >> c;
    if (a > c) {
      cout << c << endl;
      continue;
    }
    long long x = b / c;
    x++;
    cout << c * x << endl;
  }
}
