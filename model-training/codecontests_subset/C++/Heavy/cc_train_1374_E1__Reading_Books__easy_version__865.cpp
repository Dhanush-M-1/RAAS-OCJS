#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, t, a, b;
  long long ans = 0;
  priority_queue<int, vector<int>, greater<int>> book[3];
  scanf("%d%d", &n, &k);
  while (n--) {
    scanf("%d%d%d", &t, &a, &b);
    if (a && b)
      book[0].push(t);
    else if (a)
      book[1].push(t);
    else if (b)
      book[2].push(t);
  }
  if (book[0].size() + book[1].size() < k ||
      book[0].size() + book[2].size() < k)
    printf("-1\n");
  else {
    while (!book[0].empty() && k--)
      if (book[1].empty() || book[2].empty() ||
          book[0].top() <= book[1].top() + book[2].top()) {
        ans += book[0].top();
        book[0].pop();
      } else {
        ans += book[1].top() + book[2].top();
        book[1].pop();
        book[2].pop();
      }
    while ((k--) > 0) {
      ans += book[1].top() + book[2].top();
      book[1].pop();
      book[2].pop();
    }
    printf("%lld\n", ans);
  }
}
