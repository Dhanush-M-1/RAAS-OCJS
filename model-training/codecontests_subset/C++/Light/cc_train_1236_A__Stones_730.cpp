#include <bits/stdc++.h>
using namespace std;
int beat(string s);
int main() {
  int t;
  cin >> t;
  vector<int> a(t), b(t), c(t), score(t, 0);
  for (int i = 0; i < t; i++) cin >> a[i] >> b[i] >> c[i];
  for (int i = 0; i < t; i++) {
    while ((b[i] >= 1 && c[i] >= 2) || (a[i] >= 1 && b[i] >= 2)) {
      while (b[i] >= 1 && c[i] >= 2) {
        score[i] += 3;
        b[i]--;
        c[i] -= 2;
      }
      while (a[i] >= 1 && b[i] >= 2) {
        score[i] += 3;
        a[i]--;
        b[i] -= 2;
      }
    }
  }
  for (int i = 0; i < t; i++) {
    cout << score[i] << endl;
  }
  return 0;
}
