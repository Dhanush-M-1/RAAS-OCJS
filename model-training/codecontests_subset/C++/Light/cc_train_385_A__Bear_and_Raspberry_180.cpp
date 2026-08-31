#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int n, c, t, m = 0;
  cin >> n >> c;
  vector<int> a;
  for (int i = 0; i < n; i++) {
    cin >> t;
    a.push_back(t);
  }
  for (int i = 0; i < n - 1; i++) {
    if (a[i] - a[i + 1] - c > m) m = a[i] - a[i + 1] - c;
  }
  cout << m << endl;
  return 0;
}
