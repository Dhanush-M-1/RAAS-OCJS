#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, x, achou;
  scanf("%d", &n);
  vector<int> v1;
  vector<int> v2;
  vector<int> v3;
  for (i = 0; i < n; i++) {
    scanf("%d", &x);
    v1.push_back(x);
  }
  sort(v1.begin(), v1.end());
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &x);
    v2.push_back(x);
  }
  sort(v2.begin(), v2.end());
  achou = 0;
  for (i = 0; i < n && !achou; i++) {
    if (i == n - 1 || v1.at(i) != v2.at(i)) {
      printf("%d\n", v1.at(i));
      achou = 1;
    }
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &x);
    v3.push_back(x);
  }
  sort(v3.begin(), v3.end());
  achou = 0;
  for (i = 0; i < n - 1 && !achou; i++) {
    if (i == n - 2 || v2.at(i) != v3.at(i)) {
      printf("%d\n", v2.at(i));
      achou = 1;
    }
  }
}
