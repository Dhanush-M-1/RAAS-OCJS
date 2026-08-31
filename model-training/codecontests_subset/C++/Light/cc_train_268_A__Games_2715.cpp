#include <bits/stdc++.h>
using namespace std;
struct tform {
  int h, g;
};
int main() {
  int n, i, j, k;
  tform a[30];
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i].h >> a[i].g;
  k = 0;
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (a[i].h == a[j].g) k++;
    }
  }
  cout << k;
  return 0;
}
