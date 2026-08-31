#include <bits/stdc++.h>
using namespace std;
pair<int, int> a[100100];
int n;
int kx[100100], ky[100100];
vector<int> first[100100], second[100100];
void read(void) {
  cin >> n;
  for (int i = 0, x1, y1; i < n; ++i) {
    cin >> x1 >> y1;
    a[i] = make_pair(x1, y1);
    first[x1].push_back(y1);
    second[y1].push_back(x1);
  }
  sort(a, a + n);
  for (int i = 0; i < 100100; ++i) {
    sort(first[i].begin(), first[i].end());
    sort(second[i].begin(), second[i].end());
  }
}
void kill(void) {
  int ans = 0;
  for (int i = 0; i < n; ++i) {
    int x1 = a[i].first;
    int y1 = a[i].second;
    ++kx[x1];
    ++ky[y1];
    int d;
    if (first[x1].size() < second[y1].size())
      for (int j = kx[x1]; j < (int)first[x1].size(); ++j) {
        d = first[x1][j] - y1;
        if (binary_search(second[y1].begin(), second[y1].end(), x1 + d) &&
            binary_search(second[y1 + d].begin(), second[y1 + d].end(), x1 + d))
          ++ans;
      }
    else
      for (int j = ky[y1]; j < (int)second[y1].size(); ++j) {
        d = second[y1][j] - x1;
        if (binary_search(first[x1].begin(), first[x1].end(), y1 + d) &&
            binary_search(first[x1 + d].begin(), first[x1 + d].end(), y1 + d))
          ++ans;
      }
  }
  cout << ans << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  read();
  kill();
  return 0;
}
