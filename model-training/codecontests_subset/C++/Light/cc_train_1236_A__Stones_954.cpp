#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, ans = 0;
    cin >> a >> b >> c;
    int t1 = min(a, b / 2);
    int a1 = t1 + 2 * t1;
    int t2 = min(b - 2 * t1, c / 2);
    a1 += t2 + 2 * t2;
    t1 = min(b, c / 2);
    int a2 = t1 + 2 * t1;
    t2 = min(a, (b - t1) / 2);
    a2 += t2 + 2 * t2;
    cout << max(a1, a2) << endl;
  }
  return 0;
}
