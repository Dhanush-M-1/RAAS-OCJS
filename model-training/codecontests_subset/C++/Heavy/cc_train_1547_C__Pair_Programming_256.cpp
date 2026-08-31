#include<bits/stdc++.h>
using namespace std;
#define int long long
signed main() {
  ios :: sync_with_stdio(false);
  cin.tie(0);
  int t; cin >> t;
  while(t--) {
    int k, n, m; cin >> k >> n >> m;
    queue<int> x, y;
    for (int i = 0; i < n; i++) {
      int v; cin >> v;
      x.push(v);
    }
    for (int i = 0; i < m; i++) {
      int v; cin >> v;
      y.push(v);
    }
    int tar = k;
    vector<int> ans;
    int f = 0;
    while(!x.empty() or !y.empty()) {
      if(!x.empty() and !y.empty()) {
        int a = x.front();
        int b = y.front();
        if (a == 0) {
          ans.push_back(a);
          x.pop();
          tar += 1;
        } else if (b == 0) {
          ans.push_back(b);
          y.pop();
          tar += 1;
        } else if (a <= b and a <= tar) {
          ans.push_back(a);
          x.pop();
        } else if (b < a and b <= tar) {
          ans.push_back(b);
          y.pop();
        } else {
          f = 1;
          break;
        }
      } else if (!x.empty()) {
        int a = x.front();
        if (a == 0) {
          ans.push_back(a);
          x.pop();
          tar += 1;
        } else if (a <= tar) {
          ans.push_back(a);
          x.pop();
        } else {
          f = 1;
          break;
        }
      } else if (!y.empty()) {
        int a = y.front();
        if (a == 0) {
          ans.push_back(a);
          y.pop();
          tar += 1;
        } else if (a <= tar) {
          ans.push_back(a);
          y.pop();
        } else {
          f = 1;
          break;
        }
      }
    }
    if (f) {
      cout << "-1" << "\n";
      continue;
    }
    for (int i = 0; i < ans.size(); i++) {
      cout << ans[i] << " ";
    }
    cout << "\n";
  }
}

