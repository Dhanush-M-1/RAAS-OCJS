#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
int n;
int main() {
  while (~scanf("%d", &n)) {
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        int tmp = i * j;
        stack<int> s;
        while (tmp) {
          s.push(tmp % n);
          tmp /= n;
        }
        if (j == 1 && i != 1)
          printf("\n");
        else if (j != 1)
          printf(" ");
        while (!s.empty()) {
          printf("%d", s.top());
          s.pop();
        }
      }
    }
    printf("\n");
  }
  return 0;
}
