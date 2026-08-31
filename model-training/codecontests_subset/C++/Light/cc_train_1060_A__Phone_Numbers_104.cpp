#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int n1 = 0, n2 = 0, n3 = 0;
  string s;
  cin >> n;
  cin >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') n1++;
  }
  n2 = n / 11;
  if (n1 == 0 || s.size() < 8) {
    cout << "0" << endl;
    return 0;
  }
  cout << min(n2, n1) << endl;
  return 0;
}
