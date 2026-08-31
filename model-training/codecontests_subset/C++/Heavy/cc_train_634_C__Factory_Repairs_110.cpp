#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 200000;
int n, k, a, b, q, day[MAX_N], fta[MAX_N], ftb[MAX_N];
void init() {
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  for (int i = 0; i < n; i++) {
    day[i] = 0;
    fta[i] = 0;
    ftb[i] = 0;
  }
}
void changeItem(int d, int k) {
  for (int i = d; i < n; i |= i + 1) {
    fta[i] += max(0, min(a, day[d] + k) - day[d]);
    ftb[i] += max(0, min(b, day[d] + k) - day[d]);
  }
  day[d] += k;
}
int getAns(int p) {
  int ans = 0;
  for (int i = p - 1; i >= 0; i &= i + 1, i--) {
    ans += ftb[i];
  }
  for (int i = n - 1; i >= 0; i &= i + 1, i--) {
    ans += fta[i];
  }
  for (int i = p + k - 1; i >= 0; i &= i + 1, i--) {
    ans -= fta[i];
  }
  return ans;
}
void handleRequest() {
  int t, d, a, p;
  scanf("%d", &t);
  switch (t) {
    case 1: {
      scanf("%d %d", &d, &a);
      changeItem(--d, a);
      break;
    }
    case 2: {
      scanf("%d", &p);
      printf("%d\n", getAns(--p));
      break;
    }
  }
}
void handleRequests() {
  for (int i = 0; i < q; i++) {
    handleRequest();
  }
}
int main() {
  init();
  handleRequests();
  return 0;
}
