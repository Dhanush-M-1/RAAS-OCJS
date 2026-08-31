#include <bits/stdc++.h>
using namespace std;
int main() {
  map<long, int> a, b;
  int v, i, n;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> v;
    a[v]++;
  }
  for (i = 0; i < n - 1; i++) {
    cin >> v;
    a[v]--;
    b[v]++;
  }
  for (i = 0; i < n - 2; i++) {
    cin >> v;
    b[v]--;
  }
  map<long, int>::iterator it;
  for (it = a.begin(); it != a.end(); it++) {
    if (it->second == 1) cout << it->first << endl;
  }
  for (it = b.begin(); it != b.end(); it++) {
    if (it->second == 1) cout << it->first << endl;
  }
  return 0;
}
