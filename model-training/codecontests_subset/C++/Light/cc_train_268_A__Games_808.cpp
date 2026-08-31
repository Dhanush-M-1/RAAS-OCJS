#include <bits/stdc++.h>
using namespace std;
struct bl {
  int x, y;
};
int main() {
  int n, cnt = 0;
  bl a[31];
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i].x >> a[i].y;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (a[i].x == a[j].y) cnt++;
  cout << cnt;
  return 0;
}
