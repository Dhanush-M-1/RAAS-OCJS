#include <bits/stdc++.h>
using namespace std;
int main() {
  map<int, int> ma1;
  map<int, int> ma2;
  ma1.clear();
  ma2.clear();
  map<int, int>::iterator it;
  int n, i, x;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &x);
    ma1[x]++;
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &x);
    ma1[x]--;
    ma2[x]++;
  }
  for (it = ma1.begin(); it != ma1.end(); it++) {
    if (it->second == 1) {
      printf("%d\n", it->first);
      break;
    }
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &x);
    ma2[x]--;
  }
  int flag = 0;
  for (it = ma2.begin(); it != ma2.end(); it++) {
    if (it->second == 1) {
      printf("%d\n", it->first);
      break;
    }
  }
  return 0;
}
