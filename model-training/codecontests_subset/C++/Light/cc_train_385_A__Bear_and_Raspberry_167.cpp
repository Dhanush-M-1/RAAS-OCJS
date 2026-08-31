#include <bits/stdc++.h>
using namespace std;
const bool debug = false;
int n, m, k, l;
const int inf = 1000 * 1000 * 1000;
const int MAKSN = 1000 + 13;
vector<int> v;
int ans = 0;
int poprz;
void readIn() {
  scanf("%d %d", &n, &m);
  scanf("%d", &poprz);
  for (int i = 0; i < (int)n - 1; i++) {
    scanf("%d", &k);
    ans = max(poprz - k, ans);
    poprz = k;
  }
  printf("%d\n", max(ans - m, 0));
}
void solve() {}
int main() {
  readIn();
  solve();
  return 0;
}
