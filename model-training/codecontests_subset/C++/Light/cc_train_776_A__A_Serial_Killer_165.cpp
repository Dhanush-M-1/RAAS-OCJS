#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
const long long Inf = 1ll << 63 - 1;
string st1, st2, tp1, tp2;
int n;
int main() {
  while (cin >> st1 >> st2) {
    cin >> n;
    cout << st1 << " " << st2 << endl;
    while (n--) {
      cin >> tp1 >> tp2;
      if (tp1 == st1) {
        st1 = tp2;
      } else {
        st2 = tp2;
      }
      cout << st1 << " " << st2 << endl;
    }
  }
  return 0;
}
