#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, cnt = 0, cnt2 = 0;
  cin >> n;
  int w;
  for (int i = 0; i < n; i++) {
    cin >> w;
    if (w == 100) cnt++;
    if (w == 200) cnt2++;
  }
  if (cnt == 0 && cnt2 % 2 != 0) {
    cout << "NO";
    return 0;
  }
  if (cnt % 2 == 0)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
