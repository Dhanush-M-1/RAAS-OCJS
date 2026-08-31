#include <bits/stdc++.h>
using namespace std;
long long int n;
vector<string> a;
void input() {
  a.clear();
  cin >> n;
  for (int i = 0; i < n; i++) {
    string k;
    cin >> k;
    a.push_back(k);
  }
}
void solve() {
  long long int z = 0, o = 0;
  if (a[0][1] == '0')
    z++;
  else
    o++;
  if (a[1][0] == '0')
    z++;
  else
    o++;
  if (a[n - 2][n - 1] == '0')
    z++;
  else
    o++;
  if (a[n - 1][n - 2] == '0')
    z++;
  else
    o++;
  if (a[0][1] == a[1][0] && a[n - 2][n - 1] == a[n - 1][n - 2] &&
      a[0][1] == a[n - 2][n - 1]) {
    cout << 2 << endl << "1 2" << endl << "2 1" << endl;
  } else if (a[0][1] == a[1][0] && a[n - 2][n - 1] == a[n - 1][n - 2] &&
             a[0][1] != a[n - 2][n - 1]) {
    cout << 0 << endl;
  } else if (z == 1) {
    if (a[0][1] == '0')
      cout << 1 << endl << "2 1" << endl;
    else if (a[1][0] == '0')
      cout << 1 << endl << "1 2" << endl;
    else if (a[n - 2][n - 1] == '0')
      cout << 1 << endl << n << " " << n - 1 << endl;
    else if (a[n - 1][n - 2] == '0')
      cout << 1 << endl << n - 1 << " " << n << endl;
  } else if (o == 1) {
    if (a[0][1] == '1')
      cout << 1 << endl << "2 1" << endl;
    else if (a[1][0] == '1')
      cout << 1 << endl << "1 2" << endl;
    else if (a[n - 2][n - 1] == '1')
      cout << 1 << endl << n << " " << n - 1 << endl;
    else if (a[n - 1][n - 2] == '1')
      cout << 1 << endl << n - 1 << " " << n << endl;
  } else {
    cout << 2 << endl;
    if (a[0][1] == '1') cout << "2 1" << endl;
    if (a[1][0] == '1') cout << "1 2" << endl;
    if (a[n - 2][n - 1] == '0') cout << n << " " << n - 1 << endl;
    if (a[n - 1][n - 2] == '0') cout << n - 1 << " " << n << endl;
  }
}
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    input();
    solve();
  }
  return 0;
}
