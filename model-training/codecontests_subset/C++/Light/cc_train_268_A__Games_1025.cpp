#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c = 0;
  cin >> n;
  int home[n], guest[n];
  for (int i = 0; i < n; i++) {
    cin >> home[i] >> guest[i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (home[i] == guest[j]) c++;
    }
  }
  cout << c << "\n";
  return 0;
}
