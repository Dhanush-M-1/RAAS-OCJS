#include <bits/stdc++.h>
using namespace std;
int main() {
  int l, j, i, count = 0;
  cin >> l;
  int a[l], b[l];
  for (i = 0; i < l; i++) {
    cin >> a[i] >> b[i];
  }
  for (i = 0; i < l; i++) {
    for (j = 0; j < l; j++) {
      if (a[i] == b[j]) {
        count++;
      }
    }
  }
  cout << count;
}
