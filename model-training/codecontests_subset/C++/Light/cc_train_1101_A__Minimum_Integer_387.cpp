#include <bits/stdc++.h>
using namespace std;
long long n, l, m, c;
int main(void) {
  cin >> n;
  for (long long i = 1; i <= n; ++i) {
    cin >> m >> c >> l;
    if (m > l) {
      cout << l << endl;
    } else {
      long long k = c / l;
      k++;
      cout << k * l << endl;
    }
  }
  return 0;
}
