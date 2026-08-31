#include <bits/stdc++.h>
using namespace std;
const int INF = 1000000;
int main() {
  int n;
  while (cin >> n) {
    int max1 = -1, max2 = -1;
    for (int i = 0; i < n; i++) {
      int a;
      cin >> a;
      if (a > INF / 2)
        max2 = max(INF - a, max2);
      else
        max1 = max(a - 1, max1);
    }
    cout << max(max1, max2) << endl;
  }
  return 0;
}
