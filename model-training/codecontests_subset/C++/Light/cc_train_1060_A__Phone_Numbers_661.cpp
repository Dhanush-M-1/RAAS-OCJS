#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ch = 0;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '8') {
      ch++;
    }
  }
  int ch1 = s.size();
  cout << min(ch, ch1 / 11);
}
