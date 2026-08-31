#include <bits/stdc++.h>
using namespace std;
void erase(multiset<int> &S, int x) {
  multiset<int>::iterator it = S.find(x);
  if (it != S.end()) S.erase(it);
}
int main() {
  int n;
  while (scanf("%d", &n) == 1) {
    multiset<int> S, T;
    for (int i = 0; i < n; ++i) {
      int x;
      scanf("%d", &x);
      S.insert(x);
    }
    for (int i = 0; i < n - 1; ++i) {
      int x;
      scanf("%d", &x);
      T.insert(x);
      erase(S, x);
    }
    int ans1 = *S.begin();
    S = T;
    for (int i = 0; i < n - 2; ++i) {
      int x;
      scanf("%d", &x);
      erase(S, x);
    }
    int ans2 = *S.begin();
    printf("%d\n%d\n", ans1, ans2);
  }
}
