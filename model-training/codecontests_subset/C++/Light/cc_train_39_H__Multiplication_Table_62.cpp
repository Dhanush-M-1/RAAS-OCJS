#include <bits/stdc++.h>
using namespace std;
stack<int> sol;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      int nn = i * j;
      while (nn > 0) {
        sol.push(nn % n);
        nn /= n;
      }
      while (!sol.empty()) {
        printf("%d", sol.top());
        sol.pop();
      }
      printf(" ");
    }
    printf("\n");
  }
  return 0;
}
