#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<long long int> v1, v2, v3;
  unsigned int n;
  long long int x;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    v1.push_back(x);
  }
  for (int i = 0; i < (n - 1); i++) {
    cin >> x;
    v2.push_back(x);
  }
  for (int i = 0; i < (n - 2); i++) {
    cin >> x;
    v3.push_back(x);
  }
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  for (int i = 0; i < n; i++) {
    if (v1[i] != v2[i]) {
      cout << v1[i] << endl;
      break;
    }
  }
  for (int i = 0; i < (n - 1); i++) {
    if (v2[i] != v3[i]) {
      cout << v2[i] << endl;
      break;
    }
  }
  return 0;
}
