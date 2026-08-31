#include <bits/stdc++.h>
using namespace std;
int n;
int a[105];
string s;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> s;
  n = 0;
  for (char ch : s) {
    if (ch != '+') {
      n++;
      a[n] = ch - '0';
    }
  }
  sort(a + 1, a + n + 1);
  for (int i = 1; i <= n; i++) {
    cout << a[i];
    if (i < n) {
      cout << '+';
    }
  }
  return 0;
}
