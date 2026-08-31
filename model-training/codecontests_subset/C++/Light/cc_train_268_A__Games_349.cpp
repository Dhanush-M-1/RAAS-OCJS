#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int x[n], y[n], cnt = 0;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> y[i];
  }
  sort(x, x + n);
  sort(y, y + n);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (x[i] == y[j]) cnt++;
    }
  }
  cout << cnt << endl;
}
