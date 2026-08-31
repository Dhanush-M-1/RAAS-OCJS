#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> a(m, 0);
  for (int i = 0; i < n; i++) {
    int ni;
    cin >> ni;
    for (int j = 0; j < ni; j++) {
      int mi;
      cin >> mi;
      a[mi - 1] = 1;
    }
  }
  int flag = 1;
  for (int i = 0; i < m; i++)
    if (a[i] == 0) flag = 0;
  if (flag)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
