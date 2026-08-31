#include <bits/stdc++.h>
using namespace std;
int main(int argc, char** argv) {
  int n, k, x;
  vector<int> v1;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> x;
    v1.push_back(x);
  }
  sort(v1.begin(), v1.end());
  for (int i = n - 1; i >= 0; i--) {
    if (k % v1[i] == 0) {
      cout << k / v1[i];
      break;
    }
  }
  return 0;
}
