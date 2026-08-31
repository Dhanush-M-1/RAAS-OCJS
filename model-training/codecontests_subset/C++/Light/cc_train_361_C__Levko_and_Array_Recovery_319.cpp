#include <bits/stdc++.h>
using namespace std;
int n, m, v[5100][4];
bool solved[5100];
int val[5100];
void f(int p);
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> m;
  for (int i = 1; i <= m; i++) cin >> v[i][1] >> v[i][2] >> v[i][3] >> v[i][4];
  for (int i = 1; i <= n; i++) f(i);
  for (int i = 1; i <= m; i++) {
    if (v[i][1] == 2 && !solved[i]) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; i++) cout << val[i] << ' ';
  return 0;
}
void f(int p) {
  int initial = 1e9, add = 0;
  for (int i = 1; i <= m; i++) {
    if (v[i][1] == 1 && v[i][2] <= p && v[i][3] >= p) {
      add += v[i][4];
    }
    if (v[i][1] == 2 && v[i][2] <= p && v[i][3] >= p) {
      if (v[i][4] < initial + add) initial = v[i][4] - add;
    }
  }
  val[p] = initial;
  add = 0;
  for (int i = 1; i <= m; i++) {
    if (v[i][1] == 1 && v[i][2] <= p && v[i][3] >= p) add += v[i][4];
    if (v[i][1] == 2 && v[i][2] <= p && v[i][3] >= p &&
        v[i][4] == initial + add)
      solved[i] = 1;
  }
}
