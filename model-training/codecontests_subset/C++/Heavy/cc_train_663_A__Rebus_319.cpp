#include <bits/stdc++.h>
using namespace std;
char arr[300];
int n;
int main() {
  int cnt = 0;
  int mx = 0, mn = 0;
  for (; true; cnt++) {
    cin >> arr[cnt];
    if (arr[cnt] == '=') {
      cin >> n;
      mx = n;
      mn = 1;
      break;
    }
  }
  for (int i = 1; i < cnt; i += 2) {
    if (arr[i] == '+') {
      mx += n;
      mn += 1;
    } else {
      mx -= 1;
      mn -= n;
    }
  }
  if (mx >= n && mn <= n) {
    cout << "Possible\n";
    int diffMx = mx - n;
    cout << max(1, n - diffMx) << ' ';
    diffMx = max(diffMx - n + 1, 0);
    for (int i = 1; i < cnt; i += 2) {
      cout << arr[i] << ' ';
      if (arr[i] == '+') {
        cout << max(1, n - diffMx) << ' ';
        diffMx = max(diffMx - n + 1, 0);
      } else {
        cout << min(1 + diffMx, n) << ' ';
        diffMx = max(0, diffMx - n + 1);
      }
    }
    cout << "= " << n << endl;
  } else {
    cout << "Impossible\n";
  }
  return 0;
}
