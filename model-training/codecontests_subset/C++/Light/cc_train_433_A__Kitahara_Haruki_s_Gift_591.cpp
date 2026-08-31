#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int w;
  int s = 0;
  int s1 = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> w;
    if (w == 100)
      s++;
    else
      s1++;
  }
  if (n == 1) {
    cout << "NO" << endl;
    return 0;
  }
  if (s % 2 != 0 || s1 % 2 != 0 && s == 0)
    cout << "NO" << endl;
  else
    cout << "YES" << endl;
  return 0;
}
