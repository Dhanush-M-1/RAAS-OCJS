#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  int x, cnt = 0, cnt2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> x;
    if (x == 100)
      cnt++;
    else
      cnt2++;
  }
  if (cnt > 0 && cnt % 2 == 0 || cnt2 > 0 && cnt2 % 2 == 0 && cnt % 2 == 0)
    cout << "YES"
         << "\n";
  else
    cout << "NO"
         << "\n";
  return 0;
}
