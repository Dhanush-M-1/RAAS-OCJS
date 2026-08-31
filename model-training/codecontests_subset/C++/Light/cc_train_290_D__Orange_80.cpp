#include <bits/stdc++.h>
using namespace std;
vector<int> a[100005];
vector<int> c[100005];
int main() {
  string s;
  int n;
  cin >> s;
  cin >> n;
  for (int i = 0; i < s.length(); ++i) s[i] = tolower(s[i]);
  for (int i = 0; i < s.length(); ++i) {
    int p = (int)s[i];
    if (p < (n + 97))
      s[i] = toupper(s[i]);
    else
      s[i] = tolower(s[i]);
  }
  cout << s;
  return 0;
}
