#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 10;
vector<int> v[maxn];
bool mark[maxn];
int p[maxn];
int n;
int m;
inline void input();
inline void ok_ans();
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  input();
  ok_ans();
}
inline void input() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> p[i];
  }
  for (int i = 1; i <= m; i++) {
    int l;
    int r;
    cin >> l >> r;
    v[l].push_back(r);
  }
}
inline void ok_ans() {
  mark[p[n]] = 1;
  int ans = 0;
  for (int i = n - 1; i >= 1; i--) {
    int j = 0;
    for (int k = 0; k < v[p[i]].size(); k++) {
      if (mark[v[p[i]][k]] == true) {
        j++;
      }
    }
    if (j == n - i - ans) {
      ans++;
    } else {
      mark[p[i]] = true;
    }
  }
  cout << ans;
}
