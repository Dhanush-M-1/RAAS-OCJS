#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  int a;
  cin >> n;
  int k = 0, t = 0, count = 0;
  while (n--) {
    cin >> a;
    if (a == 100) k++;
    if (a == 200) t++;
  }
  if (k % 2 == 1)
    count++;
  else {
    if (t % 2 == 1) {
      if (k == 0) count++;
    }
  }
  if (count == 0)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
}
