#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  vector<int> d(a);
  for (int i = 0; i < a; i++) {
    scanf("%d", &d[i]);
  }
  int l = 0, k = 0;
  for (int i = 0; i < a - 1; i++) {
    l = d[i] - d[i + 1];
    k = max(k, l);
  }
  l = k - b;
  if (l <= 0) {
    cout << 0;
  } else {
    cout << l;
  }
  return 0;
}
