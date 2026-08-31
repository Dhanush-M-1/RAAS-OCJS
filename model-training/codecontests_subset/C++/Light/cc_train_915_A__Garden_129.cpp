#include <bits/stdc++.h>
using namespace std;
const int MAX = 1001;
int An[MAX];
int main() {
  int n, l;
  cin >> n >> l;
  for (int i = 0; i < n; i++) cin >> An[i];
  sort(An, An + n, greater<int>());
  for (int i = 0; i < n; i++) {
    if (l % An[i] == 0) {
      cout << l / An[i] << endl;
      break;
    }
  }
  return 0;
}
