#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
void solve() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  vector<vector<int> > v(26);
  for (int i = 0; i < n; i++) {
    char a = s[i];
    char k = a;
    k++;
    for (char j = k; j <= 'z'; j++) {
      int x = j - 'a';
      if (v[x].size() > 0) {
        cout << "YES" << endl;
        cout << v[x].back() + 1 << " " << i + 1 << endl;
        return;
      }
    }
    v[a - 'a'].push_back(i);
  }
  cout << "NO" << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int tests = 1;
  while (tests--) {
    solve();
  }
}
