#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  scanf("%d", &n), scanf("%d", &m);
  int no, x;
  set<int> s;
  for (int i = 0; i < n; ++i) {
    scanf("%d", &no);
    for (int i = 0; i < no; ++i) {
      scanf("%d", &x);
      s.insert(x);
    }
  }
  int siz = (int)s.size();
  if (siz == m)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
