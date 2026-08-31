#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 10;
int bj[N];
vector<int> e[N];
int n, m;
int arr[N];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &arr[i]);
  }
  for (int i = 1, x, y; i <= m; i++) {
    scanf("%d%d", &x, &y);
    e[x].push_back(y);
  }
  bj[arr[n]] = 1;
  int ans = 1;
  for (int i = n - 1; i >= 1; i--) {
    int flag = 0;
    for (int v : e[arr[i]]) {
      if (bj[v]) flag++;
    }
    if (flag == ans) {
      bj[arr[i]] = 0;
    } else {
      bj[arr[i]] = 1;
      ans++;
    }
  }
  cout << n - ans << endl;
  return 0;
}
