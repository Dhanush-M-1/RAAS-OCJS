#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  char s;
  int st = 1, n;
  vector<int> cf;
  while (true) {
    cin >> s;
    if (s == '=') break;
    if (s == '?')
      cf.push_back(st);
    else if (s == '+')
      st = 1;
    else
      st = -1;
  }
  cin >> n;
  int l = 0, r = 0;
  vector<int> ans;
  for (int it : cf) {
    if (it == 1) {
      l++;
      r += n;
    } else {
      --r;
      l -= n;
    }
    ans.push_back(it == 1 ? n : 1);
  }
  if (l > n || r < n) {
    cout << "Impossible";
    return 0;
  }
  for (int i = 0; i < int(ans.size()); i++) {
    int old = ans[i];
    if (cf[i] == 1)
      ans[i] = max(1, ans[i] - (r - n));
    else
      ans[i] = min(n, ans[i] + (r - n));
    r -= (old - ans[i]) * cf[i];
  }
  cout << "Possible\n";
  for (int i = 0; i < int(ans.size()); i++) {
    cout << ans[i] << " ";
    if (i < int(ans.size()) - 1) cout << (cf[i + 1] == 1 ? "+ " : "- ");
  }
  cout << "= " << n;
  return 0;
}
