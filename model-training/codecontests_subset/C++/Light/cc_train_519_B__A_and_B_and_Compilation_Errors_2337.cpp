#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> v(n), vn(n - 1), vnn(n - 2);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> vn[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> vnn[i];
  }
  sort(v.begin(), v.end());
  sort(vn.begin(), vn.end());
  sort(vnn.begin(), vnn.end());
  for (int i = 0; i < n; i++) {
    if (v[i] != vn[i]) {
      cout << v[i] << endl;
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (vn[i] != vnn[i]) {
      cout << vn[i] << endl;
      break;
    }
  }
}
