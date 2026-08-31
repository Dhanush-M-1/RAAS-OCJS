#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const double eps = 1e-9;
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int a, b, c;
  cin >> a >> b >> c;
  int needed = (a * c) - (b * c);
  if (needed % b == 0) {
    cout << needed / b;
  } else {
    cout << (needed / b) + 1;
  }
  return 0;
}
