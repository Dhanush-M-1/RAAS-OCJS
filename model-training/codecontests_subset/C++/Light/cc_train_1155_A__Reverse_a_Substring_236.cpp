#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long int n, i;
  cin >> n;
  string s;
  cin >> s;
  long int flag = 0;
  for (i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      char temp;
      temp = s[i + 1];
      s[i + 1] = s[i];
      s[i] = temp;
      flag = 1;
      break;
    }
  }
  if (flag == 1) {
    cout << "YES" << '\n';
    cout << i + 1 << " " << i + 2 << '\n';
  } else {
    cout << "NO" << '\n';
  }
}
