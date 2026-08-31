#include <bits/stdc++.h>
using namespace std;
struct xjy {
  int mid[4];
};
vector<xjy> s;
int main() {
  int n, m;
  cin >> n >> m;
  int ans[n + 1], finans[n + 1];
  for (int i = 0; i < m; i++) {
    xjy mid;
    cin >> mid.mid[0] >> mid.mid[1] >> mid.mid[2] >> mid.mid[3];
    s.push_back(mid);
  }
  for (int i = 1; i <= n; i++) ans[i] = 1000000000;
  for (int i = s.size() - 1; i >= 0; i--) {
    if (s[i].mid[0] == 1) {
      for (int j = s[i].mid[1]; j <= s[i].mid[2]; j++)
        if (ans[j] != 1000000000) ans[j] -= s[i].mid[3];
    } else {
      for (int j = s[i].mid[1]; j <= s[i].mid[2]; j++)
        if (ans[j] > s[i].mid[3]) ans[j] = s[i].mid[3];
    }
  }
  for (int i = 1; i <= n; i++) finans[i] = ans[i];
  for (int i = 0; i < s.size(); i++) {
    if (s[i].mid[0] == 1) {
      for (int j = s[i].mid[1]; j <= s[i].mid[2]; j++) {
        ans[j] += s[i].mid[3];
      }
    } else {
      int maxx = ans[s[i].mid[1]];
      for (int j = s[i].mid[1]; j <= s[i].mid[2]; j++) {
        maxx = max(ans[j], maxx);
      }
      if (maxx != s[i].mid[3]) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) cout << finans[i] << " ";
}
