#include <bits/stdc++.h>
using namespace std;
const int N = 212;
char s[N];
void print(vector<pair<int, int>> &resp) {
  printf("%d\n", (int)resp.size());
  for (auto a : resp) {
    printf("%d %d\n", a.first, a.second);
  }
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int n;
    scanf("%d", &n);
    int a1, a2, b1, b2;
    for (int i = 0; i < n; i++) {
      scanf("%s", s);
      if (i == 0) a1 = s[1] - '0';
      if (i == 1) a2 = s[0] - '0';
      if (i == n - 2) b1 = s[n - 1] - '0';
      if (i == n - 1) b2 = s[n - 2] - '0';
    }
    vector<pair<int, int>> resp;
    if (a1 == a2) {
      int o = 1 - a1;
      if (b1 != o) resp.push_back({n - 1, n});
      if (b2 != o) resp.push_back({n, n - 1});
    } else if (b1 == b2) {
      int o = 1 - b1;
      if (a1 != o) resp.push_back({1, 2});
      if (a2 != o) resp.push_back({2, 1});
    } else {
      if (a1 != 0) resp.push_back({1, 2});
      if (a2 != 0) resp.push_back({2, 1});
      if (b1 != 1) resp.push_back({n - 1, n});
      if (b2 != 1) resp.push_back({n, n - 1});
    }
    print(resp);
  }
}
