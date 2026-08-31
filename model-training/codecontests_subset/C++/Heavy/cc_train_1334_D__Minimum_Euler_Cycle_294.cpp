#include <bits/stdc++.h>
using namespace std;
const int MAX = 2e6 + 5, MOD = 1e9 + 7, MAXLG = log2(MAX) + 1;
const long long inf = 1e18 + 5;
int arr[MAX];
vector<long long> v;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  int t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    int len = r - l + 1;
    long long L = 0, R = 0;
    bool lt = false, rt = false;
    int lid = 0, rid = 0;
    for (int i = 1; i < n; i++) {
      long long val = 2ll * (n - i);
      if (!lt && L + val < l)
        L += val, lid = i;
      else
        lt = true;
      if (!rt && R + val < r)
        R += val, rid = i;
      else
        rt = true;
    }
    l -= (L + 1);
    lid++, rid++;
    deque<int> ans;
    for (int i = lid; i <= rid; i++) {
      for (int j = i + 1; j <= n; j++) {
        ans.push_back(i);
        ans.push_back(j);
      }
    }
    while (l--) ans.pop_front();
    while ((int)ans.size() > len) ans.pop_back();
    if ((int)ans.size() < len) ans.push_back(1);
    for (int x : ans) cout << x << " ";
    cout << "\n";
  }
}
