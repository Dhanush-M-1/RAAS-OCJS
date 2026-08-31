#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, cnt = 0;
  string s;
  cin >> n >> s;
  for (int i = 0; i < s.size(); ++i) {
    if (s[i] == '8') ++cnt;
  }
  cout << min(cnt, n / 11) << endl;
  return 0;
}
