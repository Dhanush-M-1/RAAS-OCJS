#include <bits/stdc++.h>
using namespace std;
int main() {
  long long T;
  cin >> T;
  while (T--) {
    long long n;
    cin >> n;
    long long a[n + 1];
    vector<int> vct;
    for (int i = 1; i <= n; i++) {
      cin >> a[i];
    }
    bool b = false;
    bool flag = false;
    int k = 3;
    for (int i = 3; i <= n; i++) {
      vct.push_back(i);
      if (a[1] + a[2] <= a[i]) {
        k = i;
        b = true;
        flag = true;
        break;
      }
    }
    if (b == true) {
      cout << 1 << " " << 2 << " " << k << "\n";
    } else {
      cout << "-1\n";
    }
  }
  return 0;
}
