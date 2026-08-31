#include <bits/stdc++.h>
using namespace std;
int n;
string s1, s2, s3, s4;
int main() {
  cin >> s1 >> s2 >> n;
  cout << s1 << ' ' << s2 << endl;
  for (int i = 1; i <= n; ++i) {
    cin >> s3 >> s4;
    if (s1 == s3) s1 = s4;
    if (s2 == s3) s2 = s4;
    cout << s1 << ' ' << s2 << endl;
  }
}
