#include <bits/stdc++.h>
using namespace std;
const int Z = (int)3e3 + 228;
const int N = (int)3e5 + 228;
const int INF = (int)1e9 + 228;
const int MOD = (int)1e9 + 7;
int a[N];
map<int, int> cnt;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<int> b;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    b.push_back(a[i]);
  }
  sort(b.rbegin(), b.rend());
  int m;
  cin >> m;
  while (m--) {
    int k, pos;
    cin >> k >> pos;
    multiset<int> mn;
    map<int, int> q;
    for (int i = 0; i < k; i++) mn.insert(b[i]), q[b[i]]++;
    vector<int> ans;
    for (int i = 1; i <= n; i++) {
      if (k == 0) break;
      if (mn.find(a[i]) != mn.end()) {
        if (a[i] == *mn.begin()) {
          ans.push_back(a[i]);
          q[a[i]]--;
          mn.erase(mn.begin());
          k--;
        }
        map<int, int> now;
        for (int j = i + 1; j <= n; j++) now[a[j]]++;
        bool f = true;
        for (auto it : mn)
          if (q[it] > now[it]) f = false;
        if (f)
          continue;
        else {
          ans.push_back(a[i]);
          q[a[i]]--;
          mn.erase(mn.find(a[i]));
          k--;
        }
      }
    }
    cout << ans[pos - 1] << "\n";
  }
  return 0;
}
