#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:1024000000,1024000000")
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  string s1, s2;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cout << s1 << " " << s2 << endl;
    string t1, t2;
    cin >> t1 >> t2;
    if (t1 == s1)
      s1 = t2;
    else
      s2 = t2;
  }
  cout << s1 << " " << s2 << endl;
  return 0;
}
