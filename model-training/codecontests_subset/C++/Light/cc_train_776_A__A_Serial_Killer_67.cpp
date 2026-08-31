#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j;
  string alive[1005], dead[1005], c, d;
  cin >> c >> d;
  cin >> n;
  for (i = 1; i < n + 1; i++) {
    cin >> dead[i] >> alive[i];
  }
  dead[0] = c;
  alive[0] = d;
  cout << c << " " << d << "\n";
  for (i = 1; i < n + 1; i++) {
    if (dead[i] == dead[0]) {
      dead[0] = alive[i];
    } else if (dead[i] == alive[0]) {
      alive[0] = alive[i];
    }
    cout << dead[0] << " " << alive[0] << "\n";
  }
  return 0;
}
