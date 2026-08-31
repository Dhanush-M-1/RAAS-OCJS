#include <bits/stdc++.h>
using namespace std;
const long long N = 30;
long long a, b, res1, res2, last, tmp;
int32_t main() {
  cout << "?"
       << " " << 0 << " " << 0 << endl;
  cin >> last;
  for (long long i = N - 1; i >= 0; i--) {
    long long ans1, pw = (1LL << i);
    cout << "?"
         << " " << res1 + pw << " " << res2 + pw << endl;
    cin >> tmp;
    ans1 = tmp;
    if (!tmp) {
      cout << "?"
           << " " << res1 + pw << " " << res2 << endl;
      cin >> tmp;
      if (tmp == -1) {
        res1 += pw;
        res2 += pw;
      }
      last = 0;
    } else if (tmp == last) {
      cout << "?"
           << " " << res1 + pw << " " << res2 << endl;
      cin >> tmp;
      if (tmp == 1)
        ;
      else if (tmp == 0)
        return -1;
      else {
        res1 += pw;
        res2 += pw;
      }
      last = ans1;
    } else {
      tmp = last;
      if (tmp == 1) {
        res1 += pw;
      } else if (!tmp) {
        return -1;
      } else {
        res2 += pw;
      }
      cout << "?"
           << " " << res1 << " " << res2 << endl;
      cin >> last;
    }
  }
  cout << '!' << " " << res1 << " " << res2 << endl;
}
