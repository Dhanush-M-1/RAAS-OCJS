#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string s1, s2;
  cin >> s1 >> s2;
  int n;
  cout << s1 << " " << s2 << '\n';
  cin >> n;
  string s3, s4;
  for (int i = 1; i <= n; i++) {
    cin >> s3 >> s4;
    cout << s4 << " ";
    if (s3 == s1) {
      cout << s2;
      s1 = s4;
    } else {
      cout << s1;
      s2 = s4;
    }
    cout << '\n';
  }
  return 0;
}
