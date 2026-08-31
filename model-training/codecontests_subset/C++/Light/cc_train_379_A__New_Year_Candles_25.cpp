#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, count = 0;
  cin >> n >> x;
  count += n;
  while (n >= x) {
    count += n / x;
    n = n / x + n % x;
  }
  cout << count << endl;
  return 0;
}
