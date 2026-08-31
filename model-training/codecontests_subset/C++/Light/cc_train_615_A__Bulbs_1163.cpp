#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  bool arr[m];
  memset(arr, 0, sizeof(bool) * m);
  int count = 0;
  for (int i = 0; i < n; ++i) {
    int no;
    cin >> no;
    for (int j = 0; j < no; ++j) {
      int bulb;
      cin >> bulb;
      bulb--;
      if (arr[bulb] == 0) {
        arr[bulb] = 1;
        count++;
      }
    }
  }
  if (count == m)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
