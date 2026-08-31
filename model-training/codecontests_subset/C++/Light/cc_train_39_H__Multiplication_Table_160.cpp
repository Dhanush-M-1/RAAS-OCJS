#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:16777216")
int k;
int main() {
  cin >> k;
  for (int i = 1; i < k; ++i) {
    for (int j = 1; j < k; ++j) {
      if (j > 1) cout << " ";
      string s = "";
      int first = i * j;
      while (first) {
        s = (char)(first % k + '0') + s;
        first /= k;
      }
      cout << s;
    }
    cout << endl;
  }
}
