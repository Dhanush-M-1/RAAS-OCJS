#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int n, m, cnt, w[N], a[N], tmp[N];
bool check[N], taken[N];
void Input() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> w[i];
  for (int i = 1; i <= m; i++) cin >> a[i];
}
void Get() {
  for (int i = 1; i <= m; i++) {
    if (!taken[a[i]]) {
      cnt++, tmp[cnt] = a[i];
      taken[a[i]] = true;
    }
  }
}
void Solve() {
  int res = 0;
  for (int j = 1; j <= m; j++) {
    int sum = 0;
    for (int temp = 1; temp <= n; temp++) {
      if (tmp[temp] == a[j]) {
        int root = tmp[temp];
        for (int k = temp; k > 1; k--) tmp[k] = tmp[k - 1];
        tmp[1] = root, res += sum;
        break;
      } else
        sum += w[tmp[temp]];
    }
  }
  cout << res << '\n';
}
int main() {
  Input();
  Get();
  Solve();
  return 0;
}
