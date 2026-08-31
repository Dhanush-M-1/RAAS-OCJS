#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  long long n, m;
  while (cin >> n) {
    string st;
    cin >> st;
    long long cnt = 0;
    for (int i = 0; i < n; i++) {
      if (st[i] == 'I') cnt++;
    }
    if (cnt == 0) {
      for (int i = 0; i < n; i++)
        if (st[i] == 'A') cnt++;
      cout << cnt << endl;
    } else {
      if (cnt != 1) cnt = 0;
      cout << cnt << endl;
    }
  }
  return 0;
}
