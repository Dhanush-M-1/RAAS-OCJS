#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int k = n;
  int f = n;
  while (f >= m) {
    k += f / m;
    f = f % m + f / m;
  }
  cout << k;
  return 0;
}
