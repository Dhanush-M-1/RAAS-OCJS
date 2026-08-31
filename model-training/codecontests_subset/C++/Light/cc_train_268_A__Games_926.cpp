#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios::sync_with_stdio(false);
  int n, cnt = 0;
  cin >> n;
  vector<int> v1(n);
  vector<int> v2(n);
  for (int i = 0; i < n; i++) cin >> v1[i] >> v2[i];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (v1[i] == v2[j]) {
        cnt++;
      }
    }
  }
  cout << cnt;
  return 0;
}
