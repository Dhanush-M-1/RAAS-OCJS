#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, tk, ans;
  priority_queue<int> pq;
  scanf("%d %d", &n, &k);
  while (n--) {
    scanf("%d", &tk);
    if (tk <= k) pq.push(tk);
  }
  while (!pq.empty()) {
    if (k % pq.top() == 0) {
      ans = k / pq.top();
      break;
    } else
      pq.pop();
  }
  cout << ans << endl;
}
