#include <bits/stdc++.h>
using namespace std;
int tests(void);
int tests() {
  int n, m;
  vector<int> v;
  set<int> s1;
  set<int> s2;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    int in;
    cin >> in;
    s1.insert(in);
  }
  for (int i = 0; i < m; i++) {
    int in;
    cin >> in;
    s2.insert(in);
  }
  for (auto it = s1.begin(); it != s1.end(); it++) {
    v.push_back(*it);
  }
  for (auto it = s2.begin(); it != s2.end(); it++) {
    v.push_back(*it);
  }
  sort(v.begin(), v.end());
  for (int i = 1; i < v.size(); i++) {
    if (v[i - 1] == v[i]) {
      cout << "YES"
           << "\n";
      cout << '1' << " " << v[i] << "\n";
      return 0;
    }
  }
  cout << "NO"
       << "\n";
  return 0;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int test;
  cin >> test;
  while (test--) {
    tests();
  }
  return 0;
}
