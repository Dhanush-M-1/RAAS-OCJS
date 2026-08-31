#include <bits/stdc++.h>
using namespace std;
int fl[20005];
int mas[20005];
int res[3004];
int main() {
  memset(fl, 0, sizeof(fl));
  memset(res, 0, sizeof(res));
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> mas[i];
    fl[mas[i]] = 1;
  }
  vector<int> arr(0);
  int d = 1;
  for (int i = 1; i <= n; i++) {
    if (fl[i]) continue;
    int x = i;
    int len = 1;
    bool f = false;
    if (x == m) f = true;
    while (mas[x]) {
      len++;
      x = mas[x];
      if (x == m) {
        f = true;
        len = 1;
      }
    }
    if (f)
      d = len;
    else
      arr.push_back(len);
  }
  res[0] = 1;
  for (int i = 0; i < arr.size(); i++)
    for (int j = 1000; j >= 0; j--)
      if (res[j]) res[j + arr[i]] = 1;
  int i = 0;
  while (i + d <= n) {
    if (res[i]) cout << (i + d) << endl;
    i++;
  }
  return 0;
}
