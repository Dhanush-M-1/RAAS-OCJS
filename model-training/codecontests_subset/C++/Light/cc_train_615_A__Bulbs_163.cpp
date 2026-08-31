#include <bits/stdc++.h>
using namespace std;
void test_case() {}
int main() {
  ios::sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  set<int> bulbs;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    while (x--) {
      int a;
      cin >> a;
      bulbs.insert(a);
    }
  }
  if (bulbs.size() == m) {
    cout << "YES";
  } else {
    cout << "NO";
  }
  return 0;
}
