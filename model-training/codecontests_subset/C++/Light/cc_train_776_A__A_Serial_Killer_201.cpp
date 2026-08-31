#include <bits/stdc++.h>
using namespace std;
pair<string, string> a;
int n;
string s1, s2;
int main() {
  cin >> s1 >> s2 >> n;
  a.first = s1;
  a.second = s2;
  for (int i = 1; i <= n; i++) {
    cout << a.first << " " << a.second << endl;
    cin >> s1 >> s2;
    if (a.first == s1) {
      a.first = s2;
    } else {
      a.second = s2;
    }
  }
  cout << a.first << " " << a.second << endl;
  return 0;
}
