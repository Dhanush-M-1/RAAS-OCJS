#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int t;
  while (cin >> n) {
    int weight[n];
    t = 0;
    for (int x = 0; x < n; x++) {
      cin >> weight[x];
      t += weight[x];
    }
    int m = (t / 100) - n;
    int o = n - m;
    if (o == 0 && m == 1)
      o = 1;
    else if (o == 0 && m % 2 == 1)
      o = 1;
    if (o % 2)
      cout << "NO" << endl;
    else
      cout << "YES" << endl;
  }
}
