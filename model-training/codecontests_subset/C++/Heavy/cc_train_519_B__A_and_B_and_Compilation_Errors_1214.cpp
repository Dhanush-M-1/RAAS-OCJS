#include <bits/stdc++.h>
using namespace std;
int main() {
  map<int, int> M;
  map<int, int> Mfin1;
  map<int, int> Mfin2;
  int n, x;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    if (M.count(x)) {
      M[x]++;
      Mfin1[x]++;
      Mfin2[x]++;
    } else {
      M[x] = 1;
      Mfin1[x] = 1;
      Mfin2[x] = 1;
    }
  }
  for (int i = 0; i < (n - 1); i++) {
    cin >> x;
    Mfin1[x]--;
  }
  for (map<int, int>::iterator it = Mfin1.begin(); it != Mfin1.end(); it++) {
    if ((it->second)) {
      cout << (it->first) << endl;
      Mfin2[it->first]--;
    }
  }
  for (int i = 0; i < (n - 2); i++) {
    cin >> x;
    Mfin2[x]--;
  }
  for (map<int, int>::iterator it = Mfin2.begin(); it != Mfin2.end(); it++) {
    if ((it->second)) cout << (it->first) << endl;
  }
  return 0;
}
