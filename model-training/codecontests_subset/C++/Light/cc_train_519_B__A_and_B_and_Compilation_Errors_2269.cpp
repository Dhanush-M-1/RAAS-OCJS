#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x;
  cin >> n;
  map<int, int> a, b, c;
  map<int, int>::iterator it;
  for (int i = (int)1; i <= (int)n; i++) {
    cin >> x;
    a[x]++;
  }
  for (int i = (int)1; i <= (int)n - 1; i++) {
    cin >> x;
    b[x]++;
  }
  for (int i = (int)1; i <= (int)n - 2; i++) {
    cin >> x;
    c[x]++;
  }
  int u, v;
  for (it = a.begin(); it != a.end(); it++) {
    if (b[it->first] != a[it->first]) u = it->first;
    if (b[it->first] != c[it->first]) v = it->first;
  }
  cout << u << "\n" << v << endl;
}
