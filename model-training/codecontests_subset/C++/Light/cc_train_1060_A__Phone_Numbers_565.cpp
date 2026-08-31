#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n(0);
  cin >> n;
  string s;
  cin >> s;
  vector<int> v(10);
  for (int i = 0; s[i]; i++) {
    v[s[i] - '0']++;
  }
  long long rem = n / 11;
  long long num = v[8];
  if (v[8] == 0) {
    cout << 0 << endl;
  } else if (n < 11) {
    cout << 0 << endl;
  } else if (rem == num) {
    cout << rem << endl;
  } else if (num < rem) {
    cout << num << endl;
  } else if (rem < num) {
    cout << rem << endl;
  }
  return 0;
}
