#include <bits/stdc++.h>
using namespace std;
long long n, m, k, l = 0, r = 0;
string s2, s1, s3, s4;
long a[4][4];
int main() {
  cin >> s1 >> s2 >> n;
  cout << s1 << " " << s2 << endl;
  for (int i = 0; i < n; i++) {
    cin >> s3 >> s4;
    if (s3 == s1)
      s1 = s4;
    else
      s2 = s4;
    cout << s1 << " " << s2 << endl;
  }
  return 0;
}
