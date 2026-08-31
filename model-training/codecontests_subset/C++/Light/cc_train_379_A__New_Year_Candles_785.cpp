#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int sum = 0;
  sum += n;
  while (1) {
    sum = sum + n / m;
    n = n / m + n % m;
    if (n < m) break;
  }
  cout << sum << endl;
}
