#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n, i, e = 0, t = 0, c = 0;
  cin >> n >> s;
  for (i = 0; i < n; i++)
    if (s[i] == '8') e++;
  c = n - e;
  t = t + min(e, c / 10);
  if (e - t <= 0) {
    cout << t << endl;
    return 0;
  }
  e = e - t;
  c = c % 10;
  if (e > 0 && c >= 10) {
    t++;
    c -= 10;
  }
  t = t + (e + c) / 11;
  cout << t << endl;
}
