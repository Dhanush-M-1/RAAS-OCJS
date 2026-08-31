#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string x;
  cin >> x;
  std::vector<long long> ans;
  for (long long int i = 0; i < x.length(); i++) {
    if (x[i] != '+') ans.push_back(int(x[i] - '0'));
  }
  sort((ans).begin(), (ans).end());
  for (long long int i = 0; i < ans.size(); i++) {
    cout << ans[i];
    if (i != ans.size() - 1) cout << "+";
  }
}
