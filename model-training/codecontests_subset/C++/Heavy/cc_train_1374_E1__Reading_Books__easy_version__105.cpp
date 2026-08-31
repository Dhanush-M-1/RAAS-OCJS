#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using dl = double;
const int N = 2e5 + 10;
ll aarray[200000 + 10];
ll magic[101][101];
vector<ll> primes;
bool prime[1000001];
int main() {
  ios_base::sync_with_stdio(false);
  string str;
  ll c, d, e, f, x, y, k, a, b, t, A = 0, mod, B = 0, L, j, i, l, r, m, n,
                                   C = 0, ans = 0, sum = 0, sum1 = 0;
  vector<pair<ll, ll>> v, v1;
  queue<ll> qu;
  cin >> n >> k;
  multiset<ll> alice;
  multiset<ll> bob;
  multiset<ll> both;
  ll al = 0;
  ll bl = 0;
  for (i = 1; i <= n; i++) {
    cin >> t >> a >> b;
    if (a && b) {
      both.insert(t);
      al++;
      bl++;
    } else if (a) {
      alice.insert(t);
      al++;
    } else if (b) {
      bob.insert(t);
      bl++;
    }
  }
  if (al < k || bl < k) {
    cout << -1 << endl;
    return 0;
  }
  al = k, bl = k;
  auto ita = alice.begin();
  auto itb = bob.begin();
  auto itbt = both.begin();
  while (al > 0 || bl > 0) {
    if (al > 0 && bl > 0) {
      if (ita == alice.end() || itb == bob.end()) {
        ans += *itbt;
        itbt++;
        al--;
        bl--;
      } else {
        if (itbt != both.end()) {
          if (*ita + *itb < *itbt) {
            ans += *ita + *itb;
            ita++;
            itb++;
            al--;
            bl--;
          } else {
            ans += *itbt;
            itbt++;
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
      if (ita == alice.end()) {
        ans += *itbt;
        itbt++;
        al--;
        bl--;
      } else if (itbt == both.end()) {
        ans += *ita;
        ita++;
        al--;
      } else {
        if (*ita < *itbt) {
          ans += *ita;
          ita++;
          al--;
        } else {
          ans += *itbt;
          itbt++;
          al--;
          bl--;
        }
      }
    } else if (bl > 0) {
      if (itb == bob.end()) {
        ans += *itbt;
        itbt++;
        bl--;
        al--;
      } else if (itbt == both.end()) {
        ans += *itb;
        itb++;
        bl--;
      } else {
        if (*itb < *itbt) {
          ans += *itb;
          itb++;
          bl--;
        } else {
          ans += *itbt;
          itbt++;
          bl--;
          al--;
        }
      }
    }
  }
  cout << ans << endl;
  return 0;
}
