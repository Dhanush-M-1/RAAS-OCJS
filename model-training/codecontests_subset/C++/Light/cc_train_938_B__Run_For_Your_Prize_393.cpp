#include <bits/stdc++.h>
using namespace std;
int n, a[100500], mx = -999, total, cnt, id1 = 1, id2 = 1000000;
int main() {
  cin >> n;
  while (n--) {
    int x;
    cin >> x;
    total = max(total, min(x - 1, 1000000 - x));
  }
  cout << total;
  return 0;
}
