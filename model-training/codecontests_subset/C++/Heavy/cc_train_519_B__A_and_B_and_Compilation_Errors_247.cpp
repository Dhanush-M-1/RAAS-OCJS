#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5;
const int mod = 1e8;
int n;
int a[maxn], b[maxn], c[maxn];
vector<int> ans;
map<int, int> used, used1, used2;
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n - 1; i++) cin >> b[i];
  for (int i = 1; i <= n - 2; i++) cin >> c[i];
  for (int i = 1; i <= n; i++) used[a[i]]++;
  for (int i = 1; i <= n - 1; i++) used1[b[i]]++;
  for (int i = 1; i <= n; i++)
    if (used[a[i]] > used1[a[i]]) {
      ans.push_back(a[i]);
      break;
    }
  for (int i = 1; i <= n - 2; i++) used2[c[i]]++;
  for (int i = 1; i <= n - 1; i++)
    if (used1[b[i]] > used2[b[i]]) {
      ans.push_back(b[i]);
      break;
    }
  cout << ans[0] << '\n' << ans[1] << endl;
  return 0;
}
