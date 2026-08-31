#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  int n;
  cin >> n;
  string s;
  cin >> s;
  char mx = s[0];
  int fans, secans;
  fans = 1;
  bool notok = true;
  for (int i = 1; i < n; i++) {
    if (s[i] < mx) {
      secans = i + 1;
      notok = false;
      break;
    } else {
      fans = i + 1;
      mx = s[i];
    }
  }
  if (notok) {
    cout << "NO";
  } else {
    cout << "YES\n";
    cout << fans << ' ' << secans;
  }
  return 0;
}
