#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, count, sum, flag, temp;
  struct team {
    int h;
    int g;
  } t[35] = {0};
  while (cin >> n) {
    count = 0;
    for (i = 0; i < n; i++) {
      cin >> t[i].h >> t[i].g;
    }
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        if (j == i) {
          continue;
        }
        if (t[i].h == t[j].g) {
          count++;
        }
      }
    }
    cout << count << endl;
  }
  return 0;
}
