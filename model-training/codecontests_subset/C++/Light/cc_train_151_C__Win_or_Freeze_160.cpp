#include <bits/stdc++.h>
using namespace std;
long long n, br = 0, n1;
long long check(long long n) {
  for (int i = 2; i <= sqrt(n); i++) {
    if (n % i == 0) return 0;
  }
  return 1;
}
long long check1(long long n) {
  for (int i = 2; i <= sqrt(n); i++)
    if (n % i == 0) return i;
  return 0;
}
int main() {
  scanf("%lld", &n);
  n1 = n;
  if (check(n)) {
    cout << 1 << endl;
    cout << 0 << endl;
    return 0;
  }
  long long sol1 = check1(n);
  long long sol2 = check1(n / sol1);
  if (sol2 == 0) {
    cout << 2 << endl;
    return 0;
  }
  cout << 1 << endl;
  cout << sol1 * sol2 << endl;
  return 0;
}
