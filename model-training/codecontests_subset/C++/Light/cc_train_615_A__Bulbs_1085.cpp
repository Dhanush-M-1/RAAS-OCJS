#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios::sync_with_stdio(false);
  int n = 0, m = 0;
  cin >> n >> m;
  int baap[m + 1];
  for (int i = 1; i < (m + 1); ++i) {
    baap[i] = 0;
  }
  for (int i = 0; i < n; ++i) {
    int k = 0;
    cin >> k;
    for (int i = 0; i < k; ++i) {
      int temp = 0;
      cin >> temp;
      ++baap[temp];
    }
  }
  int counter = 0;
  for (int i = 1; i < (m + 1); ++i) {
    if (baap[i] == 0) {
      cout << "NO";
      break;
    } else
      ++counter;
  }
  if (counter == m) {
    cout << "YES";
  }
  return 0;
}
