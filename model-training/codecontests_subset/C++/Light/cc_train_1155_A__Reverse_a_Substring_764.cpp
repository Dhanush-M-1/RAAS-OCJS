#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int flag = 0;
  for (int i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      flag = 1;
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2;
      break;
      return 0;
    }
  }
  if (flag == 0) {
    cout << "NO" << endl;
  }
  return 0;
}
