#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, s2, s3;
  int n;
  cin >> s;
  cin >> n;
  s2 = "";
  for (int i = 0; i < s.length(); i++) {
    if (s[i] >= 'a' && s[i] <= 'z')
      s2 += s[i];
    else
      s2 += (s[i] + 'a' - 'A');
  }
  s3 = "";
  for (int i = 0; i < s.length(); i++) {
    if (s2[i] < n + 97)
      s3 += (s2[i] + 'A' - 'a');
    else
      s3 += s2[i];
  }
  cout << s3 << endl;
}
