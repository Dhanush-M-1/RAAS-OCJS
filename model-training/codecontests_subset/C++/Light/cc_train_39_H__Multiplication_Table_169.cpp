#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  for (int i = 0; i < k - 1; ++i) {
    for (int j = 0; j < k - 1; ++j) {
      int cur = (i + 1) * (j + 1);
      string ts = "";
      while (cur) ts = (char)(cur % k + '0') + ts, cur /= k;
      cout << ts << " ";
    }
    cout << endl;
  }
  return 0;
}
