#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  vector<int> v1;
  vector<int> v2;
  while (t--) {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i <= n - 1; i++) {
      int ch;
      cin >> ch;
      v1.push_back(ch);
    }
    for (int j = 0; j <= m - 1; j++) {
      int ch2;
      cin >> ch2;
      v2.push_back(ch2);
    }
    sort(v1.begin(), v1.end());
    sort(v2.begin(), v2.end());
    vector<int> v(v1.size() + v2.size());
    vector<int>::iterator it, st;
    it =
        set_intersection(v1.begin(), v1.end(), v2.begin(), v2.end(), v.begin());
    int k = v.size();
    if ((k == (v1.size() + v2.size())) && (v[0] == 0) && (v[k - 1] == 0)) {
      cout << "NO"
           << "\n";
    } else {
      cout << "YES"
           << "\n"
           << 1 << " " << v[0] << "\n";
    }
    v1.clear();
    v2.clear();
    v.clear();
  }
}
