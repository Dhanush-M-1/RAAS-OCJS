#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int res = 0;
  int maxx = 0;
  for (int i = 0; i < n; i++) {
    int tp;
    cin >> tp;
    maxx = max(tp, maxx);
    res += tp;
  }
  int i;
  for (i = maxx;; i++) {
    if (i * n > res * 2) break;
  }
  cout << i << endl;
  return 0;
}
