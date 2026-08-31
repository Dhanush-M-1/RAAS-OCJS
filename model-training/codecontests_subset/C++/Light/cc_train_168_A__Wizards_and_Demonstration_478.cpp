#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, x, y;
  cin >> n >> x >> y;
  long long int pz = (n * y / 100);
  if ((n * y) % 100 != 0) pz = pz + 1;
  if (pz <= x) {
    cout << 0;
    return 0;
  }
  cout << abs(pz - x);
}
