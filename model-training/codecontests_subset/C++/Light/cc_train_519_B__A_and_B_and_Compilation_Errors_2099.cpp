#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long long a, b, c;
  long long sum = 0, nu1, nu2;
  for (int i = 0; i < n; i++) {
    cin >> a;
    sum += a;
  }
  long long su1 = 0;
  for (int i = 0; i < n - 1; i++) {
    cin >> b;
    su1 += b;
  }
  long long x = sum - su1;
  cout << x << endl;
  su1 = 0;
  for (int i = 0; i < n - 2; i++) {
    cin >> c;
    su1 += c;
  }
  sum -= x;
  cout << sum - su1;
  cout << endl;
  return 0;
}
