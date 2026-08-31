#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  string s;
  cin >> n >> s;
  for (int i = 1; i < s.size(); i++) {
    if (s[i] < s[i - 1]) {
      cout << "YES" << endl;
      cout << i << " " << i + 1;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
