#include <bits/stdc++.h>
using namespace std;
int main() {
  int count, home[30], guest[30], final = 0;
  cin >> count;
  for (int i = 0; i < count; i++) {
    cin >> home[i] >> guest[i];
  }
  for (int i = 0; i < count; i++) {
    for (int a = 0; a < count; a++) {
      if (home[i] == guest[a]) {
        final++;
      }
    }
  }
  cout << final;
}
