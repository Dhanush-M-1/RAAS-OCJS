#include <bits/stdc++.h>
typedef long long LL;
using namespace std;

int main() {
  int n;
  cin >> n;
  vector<int> a(n);
  for (int i = 0; i < n; i ++) cin >> a[i];

  for (int i = 0; i < n; i ++) {
    for (int j = 0; j < n; j ++) {
      if (i == j) continue;

      if (abs(a[i] - a[j])%(n-1) == 0) {
        cout << a[i] << " " << a[j] << endl;
        return 0;
      }
    }
  }
}
