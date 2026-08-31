#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int cnt = 0;
  for (int i = 0; s[i]; i++) {
    if (s[i] == '8') cnt++;
  }
  cout << min(cnt, (int)s.size() / 11) << endl;
}
