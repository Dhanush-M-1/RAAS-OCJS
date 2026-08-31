#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, s[3] = {};
  cin >> n;
  int x = 3;
  for (int i = 0; i < 3; i++)
    for (int j = 0; j < n - i; j++) {
      cin >> a;
      s[i] += a;
    }
  cout << s[0] - s[1] << endl;
  cout << s[1] - s[2] << endl;
  return (0);
}
