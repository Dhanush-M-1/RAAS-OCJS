#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, x, y;
  cin >> n >> x >> y;
  if (((n * y) - 1) / 100 + 1 <= x) {
    cout << 0 << endl;
  } else
    cout << (((n * y) - 1) / 100) - x + 1;
}
