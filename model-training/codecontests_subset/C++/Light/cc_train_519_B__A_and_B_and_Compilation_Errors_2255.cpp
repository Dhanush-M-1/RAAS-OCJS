#include <bits/stdc++.h>
using namespace std;
const int Z = (int)1e5 + 13;
const int inf = (int)1e9 + 13;
const long long llinf = (long long)1e18 + 13;
int n, a, b, c;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    a += x;
  }
  for (int i = 0; i < n - 1; i++) {
    int x;
    cin >> x;
    b += x;
  }
  for (int i = 0; i < n - 2; i++) {
    int x;
    cin >> x;
    c += x;
  }
  cout << a - b << ' ' << b - c;
  return 0;
}
