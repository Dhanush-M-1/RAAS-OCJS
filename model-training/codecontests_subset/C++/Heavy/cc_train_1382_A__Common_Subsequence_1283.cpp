#include <bits/stdc++.h>
using namespace std;
int main() {
  int tc, i, n1, n2, a, b;
  vector<int> v1, v2;
  cin >> tc;
  while (tc--) {
    cin >> n1 >> n2;
    for (i = 0; i < n1; i++) {
      cin >> a;
      v1.push_back(a);
    }
    for (i = 0; i < n2; i++) {
      cin >> a;
      v2.push_back(a);
    }
    sort(v1.begin(), v1.end());
    sort(v2.begin(), v2.end());
    vector<int> v(v1.size() + v2.size());
    vector<int>::iterator it, st;
    it =
        set_intersection(v1.begin(), v1.end(), v2.begin(), v2.end(), v.begin());
    if (!(v.front()))
      cout << "NO\n";
    else {
      cout << "YES\n1 ";
      cout << v.front() << endl;
    }
    v.clear();
    v1.clear();
    v2.clear();
  }
  return 0;
}
