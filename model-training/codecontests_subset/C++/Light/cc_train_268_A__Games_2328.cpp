#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, home[32], guest[32], count;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> home[i] >> guest[i];
  }
  count = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (home[i] == guest[j]) {
        count++;
      }
    }
  }
  cout << count << endl;
}
