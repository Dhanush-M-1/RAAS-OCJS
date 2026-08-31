#include <bits/stdc++.h>
using namespace std;
void ok() {
  int n;
  cin >> n;
  string str;
  cin >> str;
  for (int i = 1; i < n; i++) {
    if (str[i] < str[i - 1]) {
      cout << "YES" << endl;
      cout << i << " " << i + 1 << endl;
      return;
    }
  }
  cout << "NO" << endl;
  return;
}
int main() {
  ok();
  return 0;
}
