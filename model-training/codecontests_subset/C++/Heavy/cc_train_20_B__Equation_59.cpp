#include <bits/stdc++.h>
using namespace std;
const long long A = 1e16, N = 228228, K = 8;
vector<long double> x;
long double d, a, b, c;
long long i, j, n;
int main() {
  cin >> a >> b >> c;
  if (!a) {
    if (!b && !c) {
      puts("-1");
      return 0;
      ;
    }
    if (!b) {
      puts("0");
      return 0;
      ;
    }
    puts("1");
    cout << setprecision(K) << -c / b;
    return 0;
    ;
  }
  d = b * b - 4 * a * c;
  if (d == 0) {
    puts("1");
    cout << setprecision(K) << (-b) / (2 * a) << "\n";
  } else if (d > 0) {
    d = sqrt(d), x.push_back((-b + d) / (2 * a)),
    x.push_back((-b - d) / (2 * a));
    sort(x.begin(), x.end());
    if (x[0] == x[1])
      puts("1"), cout << x[0];
    else
      puts("2"), cout << setprecision(K) << x[0] << "\n" << x[1];
  } else
    puts("0");
}
