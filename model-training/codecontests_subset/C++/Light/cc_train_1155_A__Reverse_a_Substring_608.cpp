#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int check = 0;
  for (int i = 0; i < s.size(); i++) {
    string s1 = s.substr(i, 2);
    string s2 = s1;
    reverse(s1.begin(), s1.end());
    if (s1 < s2) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
}
