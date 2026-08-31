#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int alpha[27];
  memset(alpha, 0, sizeof(alpha));
  int k;
  cin >> k;
  string z;
  cin >> z;
  for (int i = 0; i < z.length(); i++) {
    alpha[(z[i] - 'a') + 1]++;
  }
  vector<int> allp;
  for (int i = 0; i < 27; i++) {
    if (alpha[i] != 0) {
      allp.push_back(alpha[i]);
    }
  }
  for (int i = 0; i < allp.size(); i++) {
    if (allp[i] % k != 0) {
      cout << "-1";
      return 0;
    }
  }
  for (int w = 1; w <= k; w++) {
    for (int i = 1; i <= 26; i++) {
      for (int j = 1; j <= alpha[i] / k; j++) {
        cout << (char)(i + 'a' - 1);
      }
    }
  }
}
