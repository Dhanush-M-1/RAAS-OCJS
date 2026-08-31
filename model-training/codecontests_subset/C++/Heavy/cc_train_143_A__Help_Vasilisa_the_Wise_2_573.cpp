#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2;
bool dfs(vector<int>& a) {
  bool ans = false;
  if (a.size() == 4) {
    for (int i = 0; i < 4; ++i) {
      for (int j = 0; j < 4; ++j) {
        if (i == j) continue;
        if (a[i] == a[j]) return false;
      }
    }
    int i = a[0];
    int j = a[1];
    int s = a[2];
    int t = a[3];
    if (i + j == r1 && s + t == r2 && i + s == c1 && j + t == c2 &&
        i + t == d1 && j + s == d2) {
      cout << i << " " << j << endl;
      cout << s << " " << t << endl;
      return true;
    }
  } else {
    for (int i = 1; i <= 9; ++i) {
      a.push_back(i);
      ans = dfs(a);
      if (ans) return true;
      a.pop_back();
    }
  }
  return ans;
}
int main() {
  while (cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2) {
    vector<int> a;
    bool find = dfs(a);
    if (!find) {
      cout << -1 << endl;
    }
  }
  return 0;
}
