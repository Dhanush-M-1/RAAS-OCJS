#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, i, j, k, t, p, q;
  cin >> n >> k;
  multiset<long long> a, b, d;
  long long al = 0, bl = 0;
  for (i = 0; i < n; i++) {
    cin >> t >> p >> q;
    if (p && q) {
      d.insert(t);
      al++;
      bl++;
    } else if (p) {
      a.insert(t);
      al++;
    } else if (q) {
      b.insert(t);
      bl++;
    }
  }
  if (al < k || bl < k) {
    cout << -1 << "\n";
    return 0;
  }
  al = k, bl = k;
  long long ans = 0;
  auto ita = a.begin();
  auto itb = b.begin();
  auto itd = d.begin();
  while (al > 0 || bl > 0) {
    if (al > 0 && bl > 0) {
      if (ita == a.end() || itb == b.end()) {
        ans += *itd;
        itd++;
        al--;
        bl--;
      } else {
        if (itd != d.end()) {
          if (*ita + *itb < *itd) {
            ans += *ita + *itb;
            ita++;
            itb++;
            al--;
            bl--;
          } else {
            ans += *itd;
            itd++;
            al--;
            bl--;
          }
        } else {
          ans += *ita + *itb;
          ita++;
          itb++;
          al--;
          bl--;
        }
      }
    } else if (al > 0) {
      if (ita == a.end()) {
        ans += *itd;
        itd++;
        al--;
        bl--;
      } else if (itd == d.end()) {
        ans += *ita;
        al--;
        ita++;
      } else {
        if (*ita < *itd) {
          ans += *ita;
          al--;
          ita++;
        } else {
          ans += *itd;
          itd++;
          al--;
          bl--;
        }
      }
    } else if (bl > 0) {
      if (itb == b.end()) {
        ans += *itd;
        itd++;
        al--;
        bl--;
      } else if (itd == d.end()) {
        ans += *itb;
        bl--;
        itb++;
      } else {
        if (*itb < *itd) {
          ans += *itb;
          bl--;
          itb++;
        } else {
          ans += *itd;
          itd++;
          al--;
          bl--;
        }
      }
    }
  }
  cout << ans << "\n";
  return 0;
}
