#include <bits/stdc++.h>
using namespace std;
const int N = 100000 + 10;
int a[N], b[N], c[N];
map<int, int> cnt1, cnt2;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", a + i);
    cnt1[a[i]]++;
    cnt2[a[i]]++;
  }
  for (int i = 0; i < n - 1; i++) {
    scanf("%d", b + i);
    cnt1[b[i]]--;
  }
  for (auto ite : cnt1)
    if (ite.second > 0) {
      cout << ite.first << '\n';
      cnt2[ite.first]--;
      break;
    }
  for (int i = 0; i < n - 2; i++) {
    scanf("%d", c + i);
    cnt2[c[i]]--;
  }
  for (auto ite : cnt2)
    if (ite.second > 0) {
      cout << ite.first << '\n';
      return 0;
    }
  return 0;
}
