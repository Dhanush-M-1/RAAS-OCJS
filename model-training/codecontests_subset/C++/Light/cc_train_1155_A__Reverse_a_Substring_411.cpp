#include <bits/stdc++.h>
using namespace std;
string s;
int main() {
  int n;
  cin >> n;
  cin >> s;
  for (int i = 0; i < s.size() - 1; i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
