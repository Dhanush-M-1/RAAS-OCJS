#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 100;
int n, d;
int a[maxn];
void nhap() {
  cin >> n >> d;
  int l = 0;
  int r = 0;
  int sl = 0;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i] == 0) {
      if (r < 0) {
        sl++;
        l = 0;
        r = d;
      }
      l = max(l, 0);
    } else {
      l += a[i];
      r = min(r + a[i], d);
      if (l > d) {
        cout << -1;
        return;
      }
    }
  }
  cout << sl;
}
int main() { nhap(); }
