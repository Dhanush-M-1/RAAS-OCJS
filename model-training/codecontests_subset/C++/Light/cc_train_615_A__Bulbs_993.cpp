#include <bits/stdc++.h>
using namespace std;
int main() {
  int m, n, i;
  cin >> n >> m;
  unordered_set<int> set1;
  for (i = 0; i < n; i++) {
    int n1, x;
    cin >> n1;
    while (n1 > 0) {
      n1--;
      cin >> x;
      set1.insert(x);
    }
  }
  if (set1.size() == m)
    cout << "YES";
  else
    cout << "NO";
}
