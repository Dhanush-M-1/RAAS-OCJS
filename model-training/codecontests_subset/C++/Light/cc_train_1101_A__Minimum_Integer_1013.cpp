#include <bits/stdc++.h>
using namespace std;
long long unsigned l, r, d, t;
int main(int argc, char const *argv[]) {
  cin >> t;
  while (t--) {
    cin >> l >> r >> d;
    (d >= l) ? cout << (((r / d) + 1) * d) << endl : cout << d << endl;
  }
  return 0;
}
