#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    int d, l, r;
    cin >> l;
    cin >> r;
    cin >> d;
    bool a = false;
    bool b = false;
    if (int(ceil(float(l) / float(d))) == l / d) a = true;
    if (int(ceil(float(r) / float(d))) == r / d) b = true;
    if (a && b) {
      if (l / d > 1) {
        printf("%d\n", d);
      } else
        printf("%d\n", r + d);
    } else if (!a && !b) {
      if (ceil(float(l) / float(d)) > 1) {
        printf("%d\n", d);
      } else
        printf("%d\n", int(ceil(float(r) / float(d))) * d);
    } else if (!a && b) {
      if (ceil(float(l) / float(d)) > 1) {
        printf("%d\n", d);
      } else
        printf("%d\n", r + d);
    } else {
      if (l / d > 1) {
        printf("%d\n", d);
      } else
        printf("%d\n", int(ceil(float(r) / float(d))) * d);
    }
  }
  return 0;
}
