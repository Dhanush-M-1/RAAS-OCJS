#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 1;
int n;
int main() {
  vector<int> v1, v2, v3;
  scanf("%d", &n);
  for (int i = 1, a; i <= n; ++i) {
    scanf("%d", &a);
    v1.push_back(a);
  }
  for (int i = 1, a; i <= n - 1; ++i) {
    scanf("%d", &a);
    v2.push_back(a);
  }
  for (int i = 1, a; i <= n - 2; ++i) {
    scanf("%d", &a);
    v3.push_back(a);
  }
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  for (int i = 0; i < n; ++i)
    if (i < n - 1) {
      if (v1[i] != v2[i]) {
        printf("%d\n", v1[i]);
        break;
      }
    } else
      printf("%d\n", v1[i]);
  for (int i = 0; i < n - 1; ++i)
    if (i < n - 2) {
      if (v2[i] != v3[i]) {
        printf("%d\n", v2[i]);
        break;
      }
    } else
      printf("%d\n", v2[i]);
  return 0;
}
