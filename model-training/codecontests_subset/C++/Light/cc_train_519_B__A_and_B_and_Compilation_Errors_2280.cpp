#include <bits/stdc++.h>
using namespace std;
int n, x;
vector<int> v[3];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < n - i; j++) {
      scanf("%d", &x);
      v[i].push_back(x);
    }
  }
  for (int i = 0; i < 3; i++) {
    sort(v[i].begin(), v[i].end());
  }
  v[1].push_back(0);
  v[2].push_back(0);
  v[2].push_back(0);
  for (int i = 0; i < 2; i++) {
    int in = 0;
    for (int j = 0; j < v[i].size(); j++) {
      if (v[i][j] == v[i + 1][in]) {
        in++;
      } else {
        printf("%d\n", v[i][j]);
        break;
      }
    }
  }
}
