#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<int> v;
  int freq[10];
  memset(freq, 0, sizeof(freq));
  int k, r1, r2, c1, c2, d1, d2, x1, x2, y1, y2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  x1 = (c1 + r1 - d2) / 2;
  v.push_back(x1);
  x2 = c1 - x1;
  v.push_back(x2);
  y1 = (d2 + c2 - r2) / 2;
  v.push_back(y1);
  y2 = c2 - y1;
  v.push_back(y2);
  for (int i = 0; i < v.size(); i++) {
    k = v[i];
    if (k < 10 && k > 0) freq[k]++;
  }
  for (int i = 0; i < 10; i++) {
    if (freq[i] > 1) {
      cout << -1;
      return 0;
    }
  }
  if (x1 > 0 && x2 > 0 && y1 > 0 && y2 > 0) {
    if (x1 < 10 && x2 < 10 && y1 < 10 && y2 < 10) {
      cout << x1 << " " << y1 << "\n";
      cout << x2 << " " << y2;
    } else {
      cout << -1;
      return 0;
    }
  } else
    cout << -1;
}
