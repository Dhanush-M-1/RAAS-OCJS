#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  string a, b;
  cout << s1 << " " << s2 << endl;
  for (int i = 0; i < n; i++) {
    cin >> a >> b;
    if (a == s1)
      s1 = b;
    else if (a == s2)
      s2 = b;
    else if (b == s1)
      s1 = a;
    else if (b == s2)
      s2 = a;
    cout << s1 << " " << s2 << endl;
  }
}
