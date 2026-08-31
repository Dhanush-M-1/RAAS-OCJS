#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, a;
  cin >> n >> m;
  int num = n;
  while (n >= m) {
    a = n % m;
    n = n / m;
    num += n;
    n += a;
  }
  cout << num;
  return 0;
}
