#include <bits/stdc++.h>
using namespace std;
int n;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 1; i < n; i++) {
    cout << i;
    for (int j = 2; j < n; j++) {
      int t = i * j;
      string s;
      while (t) {
        s += char('0' + (t % n));
        t /= n;
      }
      reverse(s.begin(), s.end());
      cout << " " << s;
    }
    cout << endl;
  }
  return 0;
}
