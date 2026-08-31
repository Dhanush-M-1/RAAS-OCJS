#include <bits/stdc++.h>
using namespace std;
int n, m;
int weight[512], plan[1024];
bool vis[512];
stack<int> book, hand;
int ans;
int take(int a) {
  int taken = 0;
  while (book.top() != a) {
    hand.push(book.top());
    book.pop();
  }
  book.pop();
  while (!hand.empty()) {
    taken += weight[hand.top()];
    book.push(hand.top());
    hand.pop();
  }
  book.push(a);
  return taken;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &weight[i]);
  for (int i = 1; i <= m; i++) {
    scanf("%d", &plan[i]);
    if (!vis[plan[i]]) hand.push(plan[i]);
    vis[plan[i]] = 1;
  }
  while (!hand.empty()) {
    book.push(hand.top());
    hand.pop();
  }
  for (int i = 1; i <= m; i++) ans += take(plan[i]);
  printf("%d", ans);
  return 0;
}
