#include <bits/stdc++.h>
using namespace std;
inline void boost() {
  ios_base::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
}
string cur1, cur2;
int n;
int main() {
  boost();
  cin >> cur1 >> cur2;
  cout << cur1 << " " << cur2 << '\n';
  cin >> n;
  for (int i = 1; i <= n; i++) {
    string dead, nw;
    cin >> dead >> nw;
    if (dead == cur1)
      cur1 = cur2, cur2 = nw;
    else
      cur2 = nw;
    cout << cur1 << " " << cur2 << '\n';
  }
  return 0;
}
