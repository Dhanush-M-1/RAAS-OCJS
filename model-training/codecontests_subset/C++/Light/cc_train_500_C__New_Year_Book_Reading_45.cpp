#include <bits/stdc++.h>
using namespace std;
void err(istream_iterator<string> it) {}
template <typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
  cout << *it << " = " << a << endl;
  err(++it, args...);
}
const int mod = 1e9 + 7;
vector<int> freq(501, 0), w(501);
void solve() {
  int n, m;
  cin >> n >> m;
  int b[m + 1];
  for (int i = 1; i <= n; i++) cin >> w[i];
  for (int i = 1; i <= m; i++) {
    cin >> b[i];
    freq[b[i]]++;
  }
  vector<int> cnt(n + 1, 0);
  vector<int> temp;
  for (int i = 1; i <= m; i++) {
    if (cnt[b[i]] == 0) {
      temp.push_back(b[i]);
      cnt[b[i]]++;
    }
  }
  int len = ((int)(temp).size()), ans = 0;
  for (int i = 1; i <= m; i++) {
    int ind;
    for (int j = 0; j < len; j++) {
      if (temp[j] == b[i]) {
        ind = j;
        break;
      }
    }
    int x = temp[ind];
    for (int j = ind - 1; j >= 0; j--) {
      ans += w[temp[j]];
      temp[j + 1] = temp[j];
    }
    temp[0] = x;
  }
  cout << ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  solve();
}
