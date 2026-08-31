#include <bits/stdc++.h>
using namespace std;
int n;
string s;
vector<pair<char, int>> t;
void ReadInput() {
  cin >> n;
  t.resize(n);
  cin >> s;
  for (int i = 0; i < n; i++) t[i] = {s[i], i};
}
void Solve() {
  sort(t.begin(), t.end());
  for (int i = 1; i < n; i++)
    if (t[i].first != t[i - 1].first && t[i].second < t[i - 1].second) {
      cout << "YES\n";
      cout << t[i].second + 1 << ' ' << t[i - 1].second + 1;
      return;
    }
  cout << "NO";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  ReadInput();
  Solve();
}
