#include <bits/stdc++.h>
using namespace std;
long long t, n, m, g, o;
bool q = 1;
long long k, j, i, l, p;
vector<vector<int>> v(1e5);
vector<bool> visited(1e5, 0);
vector<int> vv, w;
queue<int> qq;
string s, h, c, u;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> g >> t;
    w.push_back(t);
    vv.push_back(g);
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (j == i) continue;
      if (w[j] == vv[i]) k++;
    }
  }
  cout << k << "\n";
  return 0;
}
