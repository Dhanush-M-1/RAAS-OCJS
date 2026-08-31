#include <bits/stdc++.h>
using namespace std;
int n;
string s;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  ;
  cin >> n;
  cin >> s;
  for (int i = 1; i < n; i++) {
    if (s[i - 1] > s[i]) {
      cout << "YES" << endl;
      cout << i << " " << i + 1 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
