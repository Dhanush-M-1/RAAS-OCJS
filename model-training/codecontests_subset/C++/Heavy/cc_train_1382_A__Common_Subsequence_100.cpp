#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    set<long long> a, b;
    long long temp;
    for (long long i = 0; i < n; i++) {
      cin >> temp;
      a.insert(temp);
    }
    for (long long i = 0; i < m; i++) {
      cin >> temp;
      b.insert(temp);
    }
    int flag = 0;
    for (auto i : a) {
      if (b.find(i) != b.end()) {
        flag = i;
        break;
      }
    }
    if (flag)
      cout << "YES" << '\n' << 1 << " " << flag << '\n';
    else
      cout << "NO" << '\n';
  }
  return 0;
}
