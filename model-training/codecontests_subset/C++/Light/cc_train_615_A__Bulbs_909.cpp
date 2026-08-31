#include <bits/stdc++.h>
using namespace std;
int n, m, x, y, k = 0;
int main() {
  cin.tie(NULL);
  ios_base::sync_with_stdio(false);
  cin >> n >> m;
  set<int> s;
  k = m;
  while (n--) {
    cin >> y;
    while (y--) {
      cin >> x;
      s.emplace(x);
    }
  }
  cout << (s.size() == k ? "YES\n" : "NO\n");
}
