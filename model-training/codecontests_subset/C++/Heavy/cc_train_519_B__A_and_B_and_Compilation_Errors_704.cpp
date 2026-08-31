#include <bits/stdc++.h>
using namespace std;
int n, a[100100], a1[100100], a2[100100];
int main() {
  while (scanf("%d", &n) != -1) {
    int ans1 = -1, ans2 = -1;
    for (int i = 0; i < n; i++) scanf("%d", a + i);
    for (int i = 0; i < n - 1; i++) scanf("%d", a1 + i);
    for (int i = 0; i < n - 2; i++) scanf("%d", a2 + i);
    map<int, int> mp;
    for (int i = 0; i < n - 1; i++) mp[a1[i]]++;
    for (int i = 0; i < n; i++) {
      if (mp[a[i]]-- <= 0) {
        ans1 = a[i];
      }
    }
    mp.clear();
    for (int i = 0; i < n - 2; i++) mp[a2[i]]++;
    for (int i = 0; i < n - 1; i++) {
      if (mp[a1[i]]-- <= 0) {
        ans2 = a1[i];
      }
    }
    printf("%d\n%d\n", ans1, ans2);
  }
  return 0;
}
