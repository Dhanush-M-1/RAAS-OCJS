#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, sum = 0;
  vector<int> u, v;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a >> b;
    u.push_back(a);
    v.push_back(b);
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (v[i] == u[j]) {
        sum++;
      }
    }
  }
  cout << sum << endl;
  return 0;
}
