#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2;
  cin >> s1 >> s2;
  cout << s1 << " " << s2 << endl;
  int n;
  cin >> n;
  while (n--) {
    string s3, s4;
    cin >> s3 >> s4;
    if (s3 == s1) {
      cout << s2 << " " << s4 << endl;
      s1 = s2;
      s2 = s4;
    } else {
      cout << s1 << " " << s4 << endl;
      s2 = s4;
    }
  }
  return 0;
}
