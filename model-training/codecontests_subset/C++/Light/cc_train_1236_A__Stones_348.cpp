#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int s = 3 * min(b, c / 2);
    if (b - min(b, c / 2) <= 0)
      cout << s;
    else
      cout << s + 3 * min((b - min(b, c / 2)) / 2, a);
    cout << "\n";
  }
}
