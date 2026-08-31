#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n;
  cin >> n;
  for (int i = 0; i < s.size(); i++) {
    int a = s[i];
    if (a >= 'A' and a <= 'Z') a += 'a' - 'A';
    if (a < n + 97)
      cout << char(a + 'A' - 'a');
    else
      cout << char(a);
  }
  cout << endl;
}
