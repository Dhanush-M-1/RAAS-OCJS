#include <bits/stdc++.h>
using namespace std;
int main() {
  std::map<int, int> m, m2, m3;
  int i, j, k;
  int n;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> j;
    m[j]++;
  }
  for (i = 0; i < n - 1; i++) {
    cin >> j;
    m2[j]++;
  }
  std::map<int, int>::iterator it;
  it = m.begin();
  for (; it != m.end(); it++) {
    j = it->first;
    if (m[j] != m2[j]) {
      cout << j << endl;
    }
  }
  for (i = 0; i < n - 2; i++) {
    cin >> j;
    m3[j]++;
  }
  it = m2.begin();
  for (; it != m2.end(); it++) {
    j = it->first;
    if (m3[j] != m2[j]) {
      cout << j << endl;
    }
  }
}
