#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int n;
  cin >> n;
  map<int, int> m, ma;
  for (int i = 0; i < n; ++i) {
    int x;
    cin >> x;
    m[x]++;
  }
  for (int i = 0; i < n - 1; ++i) {
    int x;
    cin >> x;
    m[x]--, ma[x]++;
  }
  for (auto const &i : m) {
    if (i.second != 0) cout << i.first << "\n";
  }
  for (int i = 0; i < n - 2; ++i) {
    int x;
    cin >> x;
    ma[x]--;
  }
  for (auto const &i : ma) {
    if (i.second != 0) cout << i.first << "\n";
  }
  return 0;
}
