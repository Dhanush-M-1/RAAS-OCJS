#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  while (cin >> n) {
    vector<int> v;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      int p;
      cin >> p;
      sum += p;
      v.push_back(p);
    }
    sort(v.begin(), v.end());
    int p = v[n - 1];
    int x = 0;
    for (int i = 0; i < n; i++) {
      x += p - v[i];
    }
    if (x > sum) {
      cout << p << endl;
    } else {
      int s = 0;
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        s += p - v[i];
        if (i == n - 1) {
          if (s > sum) {
            cnt = 1;
          } else {
            p += 1;
            i = -1;
            s = 0;
          }
        }
        if (cnt == 1) break;
      }
      cout << p << endl;
    }
  }
  return 0;
}
