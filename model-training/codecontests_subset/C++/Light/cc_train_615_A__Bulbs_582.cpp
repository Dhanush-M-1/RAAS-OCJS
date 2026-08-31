#include <bits/stdc++.h>
using namespace std;
int main() {
  set<int> a;
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    for (int j = 0; j < x; j++) {
      int y;
      cin >> y;
      a.insert(y);
    }
  }
  int c = 0;
  for (int e : a) c++;
  if (c == m)
    cout << "YES";
  else
    cout << "NO";
}
