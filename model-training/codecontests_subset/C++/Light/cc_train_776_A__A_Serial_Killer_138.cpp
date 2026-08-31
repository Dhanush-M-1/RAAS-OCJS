#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  set<string> S;
  string s1, s2;
  int n;
  cin >> s1 >> s2;
  cin >> n;
  cout << s1 << " " << s2 << "\n";
  S.insert(s1);
  S.insert(s2);
  for (int i = 1; i <= n; i++) {
    cin >> s1 >> s2;
    S.erase(s1);
    S.insert(s2);
    for (auto s : S) cout << s << " ";
    cout << "\n";
  }
  return 0;
}
