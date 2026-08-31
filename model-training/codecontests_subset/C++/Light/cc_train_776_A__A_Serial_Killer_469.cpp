#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2, s3, s4, s;
  cin >> s1 >> s2;
  cout << s1 << " " << s2 << endl;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> s3 >> s4;
    if (s1 == s3) {
      s = s2;
      s1 = s;
      s2 = s4;
    } else {
      s = s1;
      s1 = s;
      s2 = s4;
    }
    cout << s << " " << s4 << endl;
  }
  return 0;
}
