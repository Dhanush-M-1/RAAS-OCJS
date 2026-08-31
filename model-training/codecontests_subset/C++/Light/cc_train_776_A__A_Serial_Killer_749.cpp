#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2, s3, s4;
  cin >> s1 >> s2;
  long long n;
  cin >> n;
  cout << s1 << " " << s2 << endl;
  while (n--) {
    cin >> s3 >> s4;
    if (s3 == s1)
      s1 = s4;
    else
      s2 = s4;
    cout << s1 << " " << s2 << endl;
  }
  return 0;
}
