#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  bool b = true;
  for (int i = 1; i < n; i++)
    if (s[i] < s[i - 1]) b = false;
  if (b) {
    cout << "NO";
    return 0;
  }
  cout << "YES" << endl;
  for (int i = 1; i < n; i++)
    if (s[i] < s[i - 1]) {
      cout << i << " " << i + 1;
      return 0;
    }
  return 0;
}
