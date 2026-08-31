#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, i, x = 0, y;
  cin >> n;
  vector<long long> v1, v2, v3;
  for (i = 0; i < n; i++) {
    cin >> x;
    v1.push_back(x);
  }
  for (i = 0; i < n - 1; i++) {
    cin >> y;
    v2.push_back(y);
  }
  for (i = 0; i < n - 2; i++) {
    cin >> x;
    v3.push_back(x);
  }
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  x = 0;
  for (i = 0; i < v2.size(); i++) {
    if (v1[i] != v2[i]) {
      cout << v1[i] << endl;
      x = 1;
      break;
    }
  }
  if (x == 0) {
    cout << v1[i] << endl;
  }
  x = 0;
  for (i = 0; i < v3.size(); i++) {
    if (v2[i] != v3[i]) {
      cout << v2[i] << endl;
      x = 1;
      break;
    }
  }
  if (x == 0) {
    cout << v2[i] << endl;
  }
  return 0;
}
