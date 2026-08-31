#include <bits/stdc++.h>
using namespace std;
const long long MOD = (1e9) + 7;
const long double EPS = 0.0000001;
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  string s;
  cin >> s;
  bool flag = true;
  int where = 0;
  for (int i = 1; i < n; i++) {
    if (s[i] - s[i - 1] < 0) {
      flag = false;
      where = i + 1;
    }
  }
  if (flag) {
    cout << "NO\n";
  } else {
    cout << "YES\n";
    cout << where - 1 << " " << where << endl;
  }
  return 0;
}
