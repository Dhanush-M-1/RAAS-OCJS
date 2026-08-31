#include <bits/stdc++.h>
using namespace std;
int a[6];
vector<int> v;
int main() {
  for (int i = 0; i < 6; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      for (int k = 1; k <= 9; k++) {
        for (int l = 1; l <= 9; l++) {
          if (i + j == a[0] && k + l == a[1] && i + k == a[2] &&
              j + l == a[3] && i + l == a[4] && j + k == a[5]) {
            v.clear();
            v.push_back(i);
            v.push_back(j);
            v.push_back(k);
            v.push_back(l);
            sort(v.begin(), v.end());
            vector<int>::iterator it;
            it = unique(v.begin(), v.end());
            v.resize(distance(v.begin(), it));
            if (v.size() != 4) continue;
            printf("%d %d\n%d %d", i, j, k, l);
            return 0;
          }
        }
      }
    }
  }
  printf("-1");
  return 0;
}
