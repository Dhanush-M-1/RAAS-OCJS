#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:20000000")
string problem_name = "a";
void init() { freopen((problem_name + ".in").c_str(), "rt", stdin); }
int l[5100], r[5100], v[5100];
int tp[5100];
int mas[5100];
int u[5100];
int res[5100];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    cin >> tp[i] >> l[i] >> r[i] >> v[i];
  }
  for (int i = m - 1; i >= 0; i--) {
    if (tp[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) mas[j] -= v[i];
    } else {
      for (int j = l[i]; j <= r[i]; j++) {
        if (mas[j] > v[i])
          mas[j] = v[i];
        else if (!u[j]) {
          u[j] = 1;
          mas[j] = v[i];
        }
        u[j] = 1;
      }
    }
  }
  for (int i = 1; i <= n; i++) res[i] = mas[i];
  int ok = 1;
  for (int i = 0; i < m; i++) {
    if (tp[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) mas[j] += v[i];
    } else {
      int mx = -(1e9);
      for (int j = l[i]; j <= r[i]; j++) {
        mx = max(mx, mas[j]);
      }
      if (mx != v[i]) ok = 0;
    }
  }
  if (!ok) {
    cout << "NO";
    return 0;
  }
  cout << "YES" << endl;
  ;
  for (int i = 1; i <= n; i++) {
    cout << res[i] << " ";
  }
  return 0;
}
