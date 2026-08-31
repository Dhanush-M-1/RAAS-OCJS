#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<int> v1, v2, v3;
  int n, a;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    v1.push_back(a);
  }
  sort(v1.begin(), v1.end());
  for (int i = 0; i < n - 1; i++) {
    cin >> a;
    v2.push_back(a);
  }
  sort(v2.begin(), v2.end());
  for (int i = 0; i < n - 2; i++) {
    cin >> a;
    v3.push_back(a);
  }
  sort(v3.begin(), v3.end());
  for (int i = 0; i < n; i++) {
    if (v1[i] != v2[i]) {
      cout << v1[i] << endl;
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (v2[i] != v3[i]) {
      cout << v2[i] << endl;
      return 0;
    }
  }
  return 0;
}
