#include <bits/stdc++.h>
using namespace std;
int n, i, j, k;
vector<int> ar;
int cnvrt(int num) {
  int nn;
  ar.clear();
  while (1) {
    ar.push_back(num % n);
    num /= n;
    if (num == 0) break;
  }
  k = 1;
  nn = 0;
  for (int i = ar.size() - 1; i >= 0; i--) {
    nn = nn * 10 + ar[i];
  }
  return nn;
}
int main() {
  while (cin >> n) {
    for (i = 1; i < n; i++) {
      for (j = 1; j < n; j++) {
        cout << cnvrt(i * j) << " ";
      }
      cout << endl;
    }
  }
  return 0;
}
