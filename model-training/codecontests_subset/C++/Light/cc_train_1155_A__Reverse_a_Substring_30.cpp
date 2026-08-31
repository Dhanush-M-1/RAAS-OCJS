#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  cin >> n;
  string s;
  cin >> s;
  int flag = 0;
  long long int pos;
  for (long long int i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      flag = 1;
      pos = i;
      break;
    }
  }
  if (flag == 1) {
    cout << "YES\n";
    cout << pos << " " << pos + 1;
  } else {
    cout << "NO";
  }
  return 0;
}
