#include <bits/stdc++.h>
using namespace std;
int n;
string s;
int main() {
  cin >> n;
  cin >> s;
  bool isget = false;
  int i;
  for (i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      isget = true;
      break;
    }
  }
  if (isget) {
    cout << "YES" << endl;
    cout << i << " " << i + 1;
  } else
    cout << "NO";
  return 0;
}
