#include <bits/stdc++.h>
using namespace std;
string s, a;
bool dpn, blk;
int n;
int main() {
  ios_base::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);
  cin >> s;
  cin >> n;
  dpn = false;
  blk = false;
  for (int i = 0; i < n; i++) {
    cin >> a;
    if (a == s) {
      dpn = true;
      blk = true;
    }
    if (a[1] == s[0]) dpn = true;
    if (a[0] == s[1]) blk = true;
  }
  if (blk && dpn)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
