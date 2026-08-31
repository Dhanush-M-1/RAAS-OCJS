#include <bits/stdc++.h>
using namespace std;
int a, b, c, d, e, k[30];
string s;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> a >> s;
  for (b = 1; b < a; b++) {
    if (s[b] < s[b - 1]) {
      cout << "YES" << endl;
      cout << b << " " << b + 1;
      return 0;
    }
  }
  cout << "NO";
  return 0;
}
