#include <bits/stdc++.h>
using namespace std;
bool ispr(long long a) {
  int root = 1 + (int)sqrt((double)a);
  for (int i = 2; i <= root; i++) {
    if (a % i == 0) return false;
  }
  return true;
}
int main() {
  long long q;
  long long qq;
  cin >> q;
  qq = q;
  if (q <= 3) {
    cout << 1 << endl;
    cout << 0;
    return 0;
  }
  int n = 1 + (int)sqrt((double)q);
  int cnt = 0;
  long long chisla[2];
  chisla[0] = 1;
  chisla[1] = 1;
  int idx = 0;
  bool brk = false;
  for (int i = 2; i <= n; i++) {
    while (q % i == 0) {
      q /= i;
      cnt++;
      if (idx == 2) {
        brk = true;
        break;
      }
      chisla[idx] = i;
      idx++;
    }
    if (brk) break;
  }
  long long other = qq / ((long long)chisla[0] * (long long)chisla[1]);
  if (cnt == 0) {
    cout << 1 << endl;
    cout << 0;
    return 0;
  }
  if ((cnt == 2 && other == 1) || cnt == 1) {
    cout << 2;
    return 0;
  }
  long long hid = (chisla[0] * chisla[1]);
  cout << 1 << endl;
  cout << hid;
  return 0;
}
