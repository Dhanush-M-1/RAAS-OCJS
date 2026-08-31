#include <bits/stdc++.h>
int constexpr a[] = {0, 4, 7};
std::vector<std::map<int, std::vector<int>>> v(10);
int constexpr maxn = 20;
int constexpr maxm = 6;
bool f[maxn][maxm];
int from[maxn][maxm];
std::vector<int> bit[maxn][maxm];
int num[maxn];
long long n;
int len = 0;
void print(int l) {
  std::vector<long long> a(6);
  for (int i = l, t = 0; i; t = from[i--][t])
    for (int j = 0; j < 6; j++) a[j] = a[j] * 10 + bit[i][t][j];
  for (auto i : a) std::cout << i << ' ';
  std::cout << '\n';
}
int main() {
  std::map<int, std::vector<int>> all;
  for (int i1 = 0; i1 < 3; i1++)
    for (int i2 = 0; i2 < 3; i2++)
      for (int i3 = 0; i3 < 3; i3++)
        for (int i4 = 0; i4 < 3; i4++)
          for (int i5 = 0; i5 < 3; i5++)
            for (int i6 = 0; i6 < 3; i6++) {
              int tmp = a[i1] + a[i2] + a[i3] + a[i4] + a[i5] + a[i6];
              std::vector<int> tv{a[i1], a[i2], a[i3], a[i4], a[i5], a[i6]};
              all[tmp] = tv;
            }
  for (auto i : all) v[i.first % 10][i.first / 10] = i.second;
  int T;
  std::cin >> T;
  while (T--) {
    std::memset(f, 0, sizeof(f));
    std::cin >> n;
    auto tn = n;
    len = 0;
    for (; tn; tn /= 10) num[len++] = tn % 10;
    f[0][0] = true;
    for (int i = 0; i < len; i++)
      for (int j = 0; j < maxm; j++) {
        for (int t = 0; t < maxm; t++) {
          if (!f[i][t]) continue;
          int tj = j - (num[i] < t);
          int tmp = (num[i] - t + 10) % 10;
          for (auto k : v[tmp])
            if (k.first == tj) {
              f[i + 1][j] = true;
              from[i + 1][j] = t;
              bit[i + 1][j] = k.second;
            }
        }
      }
    if (f[len][0])
      print(len);
    else
      std::cout << "-1\n";
  }
}
