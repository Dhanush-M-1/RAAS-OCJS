#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  long long n, i = 0;
  cin >> n;
  cin >> s;
  while (i < n - 1) {
    if (s[i + 1] < s[i]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2;
      break;
    }
    i++;
  }
  if (i == (n - 1)) cout << "NO" << endl;
  return 0;
}
