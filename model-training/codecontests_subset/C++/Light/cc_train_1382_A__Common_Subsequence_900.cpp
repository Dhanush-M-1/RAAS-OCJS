#include <bits/stdc++.h>
using namespace std;
int n, m, number;
void solve() {
  cin >> n >> m;
  set<int> a;
  int answer = -1;
  for (int i = 0; i < n; i++) {
    cin >> number;
    a.emplace(number);
  }
  for (int i = 0; i < m; i++) {
    cin >> number;
    if (a.count(number) > 0) {
      answer = number;
    }
  }
  if (answer == -1) {
    cout << "NO"
         << "\n";
  } else {
    cout << "YES"
         << "\n";
    cout << 1 << " " << answer << "\n";
  }
}
int main() {
  int testCases;
  cin >> testCases;
  while (testCases--) {
    solve();
  }
}
