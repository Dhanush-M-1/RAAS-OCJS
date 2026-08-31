#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long int n, m;
    cin >> n >> m;
    long long int a[n], b[m];
    map<int, int> make_pair;
    set<int> mp1, mp2;
    for (long long int i = 0; i < n; i++) {
      cin >> a[i];
      mp1.insert(a[i]);
      make_pair[a[i]]++;
    }
    for (long long int i = 0; i < m; i++) {
      cin >> b[i];
      make_pair[b[i]]++;
      mp2.insert(b[i]);
    }
    long long int flag = 0;
    for (auto i : make_pair) {
      if (i.second > 1 && mp1.find(i.first) != mp1.end() &&
          mp2.find(i.first) != mp2.end()) {
        flag = 1;
        cout << "YES\n";
        cout << "1"
             << " " << i.first << "\n";
        break;
      }
    }
    if (!flag) cout << "NO\n";
  }
  return 0;
}
