#include <bits/stdc++.h>
using namespace std;
void testcase() {
  int n;
  cin >> n;
  int l, r, d;
  while (n--) {
    cin >> l >> r >> d;
    if (d < l || d > r) {
      cout << d << "\n";
    } else {
      int x = r / d;
      cout << (x + 1) * d << "\n";
    }
  }
}
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  testcase();
  return 0;
}
