#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 3e5;
const int INF_ = 0x3f3f3f3f;
void init() {}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  char str[MAX_N + 10];
  scanf("%d%s", &n, &str);
  bool flag = false;
  for (int i = 0; i + 1 < n; i++) {
    if (str[i] > str[i + 1]) {
      printf("YES\n");
      printf("%d %d\n", i + 1, i + 2);
      flag = true;
      break;
    }
  }
  if (!flag) printf("NO\n");
}
