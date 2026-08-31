#include <bits/stdc++.h>
using namespace std;
int a[100005], b[100005], c[100005];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  memset(c, 0, sizeof c);
  int n, count = 2;
  cin >> n;
  if (n == 1) {
    cout << 1;
  } else {
    for (int i = 1; i < n + 1; i++) {
      cin >> a[i] >> b[i];
    }
    c[1] = 1;
    for (int i = 2; i < n; i++) {
      if (a[i] - a[i - 1] > b[i]) {
        c[i] = 1;
        count++;
      } else if (a[i + 1] - a[i] > b[i] && c[i] != 1) {
        c[i] = -1;
        count++;
        a[i] += b[i];
      }
    }
    cout << count;
  }
}
