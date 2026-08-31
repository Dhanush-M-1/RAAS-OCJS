#include <bits/stdc++.h>
using namespace std;
void fast() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
}
int main() {
  fast();
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    char arr[n][n];
    long long i, j;
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        cin >> arr[i][j];
      }
    }
    long long ud = arr[1][0] - '0';
    long long ur = arr[0][1] - '0';
    long long dl = arr[n - 1][n - 2] - '0';
    long long du = arr[n - 2][n - 1] - '0';
    long long ans;
    if (ud == ur && dl == du && ud != dl) {
      cout << 0 << endl;
    } else if (ud == ur && ur == dl && dl == du) {
      cout << 2 << endl;
      cout << "1 2" << endl;
      cout << "2 1" << endl;
    } else if (ud != ur && dl != du) {
      cout << 2 << endl;
      if (ud == 1) {
        cout << "2 1" << endl;
      } else if (ur == 1) {
        cout << "1 2" << endl;
      }
      if (dl == 0) {
        cout << n << " " << n - 1 << endl;
      } else if (du == 0) {
        cout << n - 1 << " " << n << endl;
      }
    } else if (ud == ur && ur == dl && dl != du) {
      cout << 1 << endl;
      cout << n << " " << n - 1 << endl;
    } else if (ud == ur && ur == du && dl != du) {
      cout << 1 << endl;
      cout << n - 1 << " " << n << endl;
    } else if (dl == du && du == ur && ur != ud) {
      cout << 1 << endl;
      cout << "1 2" << endl;
    } else if (dl == du && du == ud && ud != ur) {
      cout << 1 << endl;
      cout << "2 1" << endl;
    }
  }
  return 0;
}
