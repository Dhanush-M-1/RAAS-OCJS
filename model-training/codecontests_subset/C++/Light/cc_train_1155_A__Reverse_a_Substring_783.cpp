#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, flag = 0;
  string s;
  cin >> n >> s;
  for (i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      flag = 1;
      break;
    }
  }
  if (flag == 0) {
    cout << "NO";
    return 0;
  }
  cout << "YES" << endl;
  cout << i + 1 << " " << i + 2;
  return 0;
}
