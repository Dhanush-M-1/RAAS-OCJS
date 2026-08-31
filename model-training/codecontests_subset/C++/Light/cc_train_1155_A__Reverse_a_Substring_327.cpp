#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  string s;
  cin >> n >> s;
  string t = s;
  sort((t).begin(), (t).end());
  if (t == s) {
    cout << "NO" << endl;
  }
  int k = 0;
  while (s[k] == t[k]) {
    k++;
  }
  for (int i = k; i < n; i++) {
    if (s[i] < s[k]) {
      cout << "YES" << endl;
      cout << k + 1 << " " << i + 1 << endl;
      return;
    }
  }
}
int main() {
  int t;
  t = 1;
  for (int i = 1; i <= t; i++) {
    solve();
  }
  return 0;
}
