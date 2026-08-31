#include <bits/stdc++.h>
using namespace std;
const long N = 1000000000;
class bulbs {
  int n, m;
  set<int> set_b;

 public:
  void read() {
    int n1, b;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
      scanf("%d", &n1);
      for (int j = 1; j <= n1; j++) {
        scanf("%d", &b);
        set_b.insert(b);
      }
    }
  }
  bool ans() {
    if (set_b.size() == m)
      return 1;
    else
      return 0;
  }
};
int main() {
  bulbs bu;
  bu.read();
  if (bu.ans())
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
