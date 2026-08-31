#include <bits/stdc++.h>
using namespace std;
vector<int> vc, ans;
set<int> ans1;
set<int>::iterator it;
int main() {
  long n, l, r, f1, f2;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    vc.push_back(x);
  }
  for (int i = 0; i < n; i++) {
    int diff = min(abs(1 - vc[i]), abs(1000000 - vc[i]));
    ans.push_back(diff);
  }
  sort(ans.begin(), ans.end());
  cout << ans[ans.size() - 1] << endl;
  return 0;
}
