#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, count = 0;
  string s;
  cin >> n >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') count++;
  }
  if (n < 11)
    cout << "0" << endl;
  else {
    cout << min(count, n / 11) << endl;
  }
  return 0;
}
