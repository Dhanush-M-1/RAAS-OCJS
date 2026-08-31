#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, l, r, d;
  cin >> n;
  while (n--) {
    cin >> l >> r >> d;
    cout << (d < l ? d : ((r / d) + 1) * d) << endl;
  }
  return 0;
}
