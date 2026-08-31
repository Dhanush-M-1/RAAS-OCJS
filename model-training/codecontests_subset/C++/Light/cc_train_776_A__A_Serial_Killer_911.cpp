#include <bits/stdc++.h>
using namespace std;
int ans = 0;
int totalTime = 0;
vector<int> cache;
int par;
int main() {
  string s, t;
  cin >> s >> t;
  int n;
  cin >> n;
  vector<string> v(n), w(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i] >> w[i];
  }
  cout << s << ' ' << t << endl;
  for (int i = 0; i < n; i++) {
    if (s == v[i]) {
      s = w[i];
    } else {
      t = w[i];
    }
    cout << s << ' ' << t << endl;
  }
  return 0;
}
