#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e2 + 5;
int vis[MAX];
int n, m;
int x;
int bulbNo;
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> x;
    for (int j = 0; j < x; j++) {
      cin >> bulbNo;
      vis[bulbNo] = 1;
    }
  }
  bool flg = 1;
  for (int i = 1; i <= m; i++) {
    if (vis[i] == 0) {
      flg = 0;
    }
  }
  if (flg == 1) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
}
