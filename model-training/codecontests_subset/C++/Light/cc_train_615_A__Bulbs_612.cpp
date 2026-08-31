#include <bits/stdc++.h>
using namespace std;
int main() {
  set<int> s;
  long long int n, m, k, a;
  cin >> n >> m;
  while (n--) {
    cin >> k;
    while (k--) {
      cin >> a;
      s.insert(a);
    }
  }
  if (s.size() == m) {
    cout << "YES"
         << "\n";
  } else {
    cout << "NO"
         << "\n";
  }
  return 0;
}
