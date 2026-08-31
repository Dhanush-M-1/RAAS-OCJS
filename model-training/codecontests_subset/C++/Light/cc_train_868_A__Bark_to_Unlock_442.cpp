#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string pass;
  cin >> pass;
  int q;
  cin >> q;
  bool ans = 0, isLeft = 0, isRight = 0;
  while (q--) {
    string tmp;
    cin >> tmp;
    if (tmp[1] == pass[0]) isLeft = true;
    if (tmp[0] == pass[1]) isRight = true;
    if (tmp == pass || (isLeft && isRight)) {
      ans = true;
      break;
    }
  }
  if (ans)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
