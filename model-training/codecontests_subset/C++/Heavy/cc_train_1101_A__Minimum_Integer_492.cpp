#include <bits/stdc++.h>
using namespace std;
int i;
int fun(int l, int r, int d) {
  if (d > r) {
    return d;
  }
  if (r == d) {
    return d * 2;
  }
  if (d < r) {
    for (i = d; i <= l; i++) {
      if (i % d == 0) {
        if (i == l) break;
        return i;
      }
    }
  }
  if (d > l) {
    int p = ceil(((double)(r + 1) / (double(d)))) * d;
    return p;
  }
  if (d < l) {
    return d;
  }
  if (d == l) {
    return (ceil((double)(r + 1) / (double)d)) * d;
  }
}
int main() {
  int l, r, d, i, j[500];
  int q;
  cin >> q;
  for (i = 0; i < q; i++) {
    cin >> l >> r >> d;
    j[i] = fun(l, r, d);
  }
  for (i = 0; i < q; i++) {
    cout << j[i] << endl;
  }
}
