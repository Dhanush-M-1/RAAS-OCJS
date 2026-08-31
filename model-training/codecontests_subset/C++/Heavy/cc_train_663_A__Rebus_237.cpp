#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  char in[10];
  int i, j, k, n;
  vector<int> plus, minus, order;
  cin >> in;
  order.push_back(1);
  plus.push_back(1);
  cin >> in;
  while (in[0] != '=') {
    if (in[0] == '+')
      plus.push_back(1), order.push_back(1);
    else
      minus.push_back(1), order.push_back(-1);
    cin >> in;
    cin >> in;
  }
  int ans = int(plus.size()) - int(minus.size());
  cin >> n;
  if (n * int(plus.size()) - int(minus.size()) < n ||
      int(plus.size()) - n * int(minus.size()) > n) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  i = 0, j = 0;
  while (ans != n) {
    if (n - ans >= n - 1) {
      plus[i++] += n - 1;
      ans += n - 1;
    } else if (n - ans > 0) {
      plus[i++] += n - ans;
      ans += (n - ans);
    } else if (n - ans <= -(n - 1)) {
      minus[j++] += n - 1;
      ans -= n - 1;
    } else {
      minus[j++] += -(n - ans);
      ans += n - ans;
    }
  }
  j = k = 0;
  printf("%d ", plus[j++]);
  for (i = 1; i < int(order.size()); i++) {
    if (order[i] == 1) {
      printf("+ %d ", plus[j++]);
    } else {
      printf("- %d ", minus[k++]);
    }
  }
  printf("= %d\n", n);
  return 0;
}
