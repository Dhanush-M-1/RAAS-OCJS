#include <bits/stdc++.h>
using namespace std;
const int mxn = 105;
int arr[mxn];
string s;
int n;
void solve() {
  int a = 0, b = 0;
  char curr = s[0];
  for (int i = 1; i < s.size(); i++) {
    if (curr <= s[i]) {
      curr = s[i];
      a = i;
    } else {
      b = i;
      break;
    }
  }
  if (b) {
    cout << "YES" << '\n' << a + 1 << " " << b + 1;
  } else {
    cout << "NO" << '\n';
  }
}
void read() { cin >> n >> s; }
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  int T = 1;
  while (T--) read(), solve();
  return 0;
}
