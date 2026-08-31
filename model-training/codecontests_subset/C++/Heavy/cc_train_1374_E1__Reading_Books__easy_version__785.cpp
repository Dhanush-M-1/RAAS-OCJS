#include <bits/stdc++.h>
using namespace std;
map<int, int> mp;
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  priority_queue<int, vector<int>, greater<int> > books, a, b;
  for (int i = 0; i < n; i++) {
    int ti, x, y;
    scanf("%d%d%d", &ti, &x, &y);
    if (x && y)
      books.push(ti);
    else if (x)
      a.push(ti);
    else if (y)
      b.push(ti);
  }
  while (!a.empty() && !b.empty()) {
    int x = a.top(), y = b.top();
    a.pop(), b.pop();
    books.push(x + y);
  }
  int ans = 0;
  if (books.size() < k) {
    printf("-1\n");
    return 0;
  }
  for (int i = 0; i < k; i++) {
    ans += books.top();
    books.pop();
  }
  printf("%d", ans);
}
