#include <bits/stdc++.h>
int teams[30][2];
using namespace std;
int main() {
  int h, a, count = 0, n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> h >> a;
    teams[i][0] = h;
    teams[i][1] = a;
  }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) {
      if (j == i) continue;
      if (teams[i][0] == teams[j][1]) count++;
    }
  cout << count;
  return 0;
}
