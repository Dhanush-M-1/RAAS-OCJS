#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s[2], in[2];
  cin >> s[0] >> s[1];
  cin >> n;
  cout << s[0] << " " << s[1] << endl;
  for (int i = 0; i < n; i++) {
    cin >> in[0] >> in[1];
    if (s[0] == in[0]) {
      s[0] = in[1];
    } else {
      s[1] = in[1];
    }
    cout << s[0] << " " << s[1] << endl;
  }
  return 0;
}
