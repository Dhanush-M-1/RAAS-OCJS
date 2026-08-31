#include <bits/stdc++.h>
std::vector<std::string> ar[10];
std::string get(int v, int k) {
  std::string re;
  while (v) {
    re += (char)(v % k + '0');
    v /= k;
  }
  return re;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i < n; ++i)
    for (int j = 1; j < n; ++j) ar[i].push_back(get(i * j, n));
  int sz[10] = {0};
  for (int i = 1; i < n; ++i)
    for (int j = 0; j < ar[i].size(); ++j)
      if (ar[i][j].size() > sz[j]) sz[j] = ar[i][j].size();
  for (int i = 1; i < n; ++i) {
    for (int j = 0; j < ar[i].size(); ++j) {
      if (j) putchar(' ');
      if (ar[i][j].size() == sz[j]) {
        for (int k = sz[j] - 1; k >= 0; --k) std::cout << ar[i][j][k];
      } else
        std::cout << " " << ar[i][j][0];
    }
    puts("");
  }
  return 0;
}
