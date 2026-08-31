#include <bits/stdc++.h>
using namespace std;
void solve() {
  string a, b;
  cin >> a >> b;
  cout << a << " " << b << endl;
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    string s;
    cin >> s;
    if (s == a)
      cin >> a;
    else
      cin >> b;
    cout << a << " " << b << endl;
  }
}
int main() {
  solve();
  return 0;
}
