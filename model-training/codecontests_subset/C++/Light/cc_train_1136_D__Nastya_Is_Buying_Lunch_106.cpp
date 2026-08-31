#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  int a[n + 4];
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  set<int> s[n + 5];
  for (int i = 0; i < m; i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    s[x].insert(y);
  }
  vector<int> v;
  v.push_back(a[n - 1]);
  for (int i = n - 2; i >= 0; i--) {
    bool flag = true;
    for (int j = 0; j < v.size(); j++) {
      if (s[a[i]].find(v[j]) == s[a[i]].end()) {
        flag = false;
        break;
      }
    }
    if (!flag) v.push_back(a[i]);
  }
  cout << n - v.size() << endl;
}
