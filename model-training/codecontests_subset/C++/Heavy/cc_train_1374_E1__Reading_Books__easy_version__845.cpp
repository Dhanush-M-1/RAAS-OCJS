#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007;
const long long PI = 3.14159265358979;
const long long INF = 1000000000000000000;
bool sortbysec(pair<long long, long long> a, pair<long long, long long> b) {
  return (a.second < b.second);
}
long long powerMod(long long a, long long b, long long M) {
  long long res = 1;
  a = a % M;
  while (b) {
    if (b % 2) res = (res * a) % M;
    b /= 2;
    a = (a * a) % M;
  }
  return res;
}
long long power(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b % 2) res = (res * a);
    b /= 2;
    a = (a * a);
  }
  return res;
}
long long modInverse(long long n, long long M) { return powerMod(n, M - 2, M); }
long long nCrModPFermat(long long n, long long r, long long M) {
  if (!r) return 1;
  long long fac[n + 1];
  fac[0] = 1;
  for (long long i = 1; i < n + 1; i++) {
    fac[i] = fac[i - 1] * i % M;
  }
  return (fac[n] * modInverse(fac[r], M) % M * modInverse(fac[n - r], M) % M) %
         M;
}
long double logABaseB(long long a, long long b) {
  return (long double)((long double)log(a) / (long double)log(b));
}
struct bookDet {
  long long t, a, b;
};
bool comp(bookDet b1, bookDet b2) { return b1.t < b2.t; }
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cout << fixed;
  cout.precision(15);
  long long t = 1;
  while (t--) {
    long long n, k;
    cin >> n >> k;
    vector<bookDet> books;
    for (long long i = 0; i < n; i++) {
      books.emplace_back(bookDet());
      cin >> books[i].t >> books[i].a >> books[i].b;
    }
    vector<bookDet> both, ali, bob, none;
    for (long long i = 0; i < n; i++) {
      if (books[i].a == 1 && books[i].b == 1) {
        both.emplace_back(books[i]);
      } else if (books[i].a == 1 && books[i].b == 0) {
        ali.emplace_back(books[i]);
      }
      if (books[i].a == 0 && books[i].b == 1) {
        bob.emplace_back(books[i]);
      }
      if (books[i].a == 0 && books[i].b == 0) {
        none.emplace_back(books[i]);
      }
    }
    sort(both.begin(), both.end(), comp);
    sort(none.begin(), none.end(), comp);
    sort(ali.begin(), ali.end(), comp);
    sort(bob.begin(), bob.end(), comp);
    long long ans = 0;
    auto bothP = both.begin(), aliP = ali.begin(), bobP = bob.begin();
    while (k && aliP != ali.end() && bobP != bob.end() && bothP != both.end()) {
      if ((*aliP).t + (*bobP).t < (*bothP).t) {
        ans += ((*aliP).t + (*bobP).t);
        aliP++;
        bobP++;
        k--;
      } else {
        ans += (*bothP).t;
        bothP++;
        k--;
      }
    }
    if (!k) {
      cout << ans << endl;
    } else {
      if (aliP != ali.end() && bobP != bob.end()) {
        while (k && aliP != ali.end() && bobP != bob.end()) {
          ans += (*aliP).t;
          ans += (*bobP).t;
          aliP++;
          bobP++;
          k--;
        }
        if (k) {
          cout << -1 << endl;
        }
      } else {
        if (bothP == both.end() || both.end() - bothP < k) {
          cout << -1 << endl;
        } else {
          while (k) {
            ans += (*bothP).t;
            bothP++;
            k--;
          }
        }
      }
      if (!k) cout << ans << endl;
    }
  }
  return 0;
}
