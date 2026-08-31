#include <bits/stdc++.h>
using namespace std;
int n, li, ri, di;
int main() {
  while (cin >> n) {
    while (n--) {
      scanf("%d %d %d", &li, &ri, &di);
      int x = (li - 1) / di;
      if (x > 0) {
        cout << di << endl;
      } else {
        x = ceil((double)(ri + 1) / di);
        cout << 1LL * di * x << endl;
      }
    }
  }
  return 0;
}
