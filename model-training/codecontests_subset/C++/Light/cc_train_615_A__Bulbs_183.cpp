#include <bits/stdc++.h>
using namespace std;
int main() {
  std::set<int> a;
  int m, n;
  cin >> n >> m;
  int i;
  int temp;
  int t1;
  for (i = 0; i < n; i++) {
    cin >> t1;
    for (int j = 0; j < t1; j++) {
      cin >> temp;
      a.insert(temp);
    }
  }
  if (m == a.size()) {
    cout << "YES";
  } else {
    cout << "NO";
  }
}
