#include <bits/stdc++.h>
using namespace std;
int main() {
  set<int> a;
  int n, m;
  cin >> n >> m;
  while (n--) {
    int x;
    cin >> x;
    while (x--) {
      int y;
      cin >> y;
      a.insert(y);
    }
  }
  if (a.size() == m)
    cout << "YES";
  else
    cout << "NO";
}
