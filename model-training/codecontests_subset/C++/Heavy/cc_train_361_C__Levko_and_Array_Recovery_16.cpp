#include <bits/stdc++.h>
using namespace std;
struct op {
  long long a, b, c, d;
};
int main() {
  int n, m;
  cin >> n >> m;
  long long arr[5004];
  long long mval[5004];
  for (int i = 0; i < 5004; ++i) {
    arr[i] = 0;
    mval[i] = 1000000000ll;
  }
  op ops[5004];
  for (int i = 0; i < m; ++i) {
    cin >> ops[i].a >> ops[i].b >> ops[i].c >> ops[i].d;
    if (ops[i].a == 1) {
      for (int j = ops[i].b; j <= ops[i].c; ++j) arr[j] += ops[i].d;
    } else {
      for (int j = ops[i].b; j <= ops[i].c; ++j)
        mval[j] = min(mval[j], ops[i].d - arr[j]);
    }
  }
  long long now[5004];
  for (int i = 0; i <= n; ++i) now[i] = mval[i];
  for (int i = 0; i < m; ++i) {
    if (ops[i].a == 1) {
      for (int j = ops[i].b; j <= ops[i].c; ++j) now[j] += ops[i].d;
    } else {
      long long ans = -1000000000000ll;
      for (int j = ops[i].b; j <= ops[i].c; ++j) ans = max(ans, now[j]);
      if (ans != ops[i].d) {
        cout << "NO\n";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; ++i) cout << mval[i] << " ";
  cout << endl;
  return 0;
}
