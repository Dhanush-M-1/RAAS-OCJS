#include <bits/stdc++.h>
using namespace std;
const int DEBUGGER = 0;
const long long MAX = 2e5 + 5;
const long long MOD = 1e9 + 7;
const long long INF = 9e18;
const double PI = 3.141592653589793238462;
long long addM(long long a, long long b) {
  return (a += b) >= MOD ? (a -= MOD) : a;
}
long long subM(long long a, long long b) {
  return (a -= b) < 0 ? (a += MOD) : a;
}
long long n, mem[MAX][11];
vector<pair<pair<long long, long long>, vector<long long> > > a;
long long dp(long long i, long long cnt) {
  if (cnt >= 11) cnt -= 10;
  if (i == n) return 0;
  if (mem[i][cnt] != -1) return mem[i][cnt];
  long long a1 = 0, a2 = 0, a3 = 0, dpi1c1 = dp(i + 1, cnt + 1);
  if (a[i].first.first != -1)
    a1 = a[i].first.first * (cnt == 10 ? 2 : 1) + dpi1c1;
  if (a[i].first.second != -1) {
    long long ad = a[i].first.second * (cnt == 10 ? 2 : 1);
    long long b1 = ad + dpi1c1;
    long long b2 = 0, c1 = 0;
    if (a[i].second.size() != 0) {
      b2 = ad + a[i].second[0] * (cnt + 1 == 10 ? 2 : 1) + dp(i + 1, cnt + 2);
      c1 = a[i].second[0] * (cnt == 10 ? 2 : 1);
      c1 += a[i].first.second * (cnt + 1 == 10 ? 2 : 1) + dp(i + 1, cnt + 2);
    }
    a2 = max({b1, b2, c1});
  }
  if (a[i].second.size() != 0) {
    long long b2 = 0, b3 = 0, ad = a[i].second[0] * (cnt == 10 ? 2 : 1);
    long long b1 = dpi1c1 + ad;
    if (a[i].second.size() > 1) {
      b2 = a[i].second[0] + a[i].second[1] +
           a[i].second[0] * (((cnt == 10) || (cnt + 1 == 10)) ? 1 : 0) +
           dp(i + 1, cnt + 2);
    }
    if (a[i].second.size() > 2) {
      b3 = a[i].second[0] + a[i].second[1] + a[i].second[2] +
           a[i].second[0] *
               (((cnt == 10) || (cnt + 1 == 10) || (cnt + 2 == 10)) ? 1 : 0) +
           dp(i + 1, cnt + 3);
    }
    a3 = max({b1, b2, b3});
  }
  return mem[i][cnt] = max({a1, a2, a3, dp(i + 1, cnt)});
}
void solve() {
  memset(mem, -1, sizeof(mem));
  n = ({
    long long TEMP;
    cin >> TEMP;
    TEMP;
  });
  for (int i = 0; i < n; i++) {
    long long k = ({
      long long TEMP;
      cin >> TEMP;
      TEMP;
    });
    vector<long long> v[3];
    while (k--) {
      long long c = ({
                      long long TEMP;
                      cin >> TEMP;
                      TEMP;
                    }) -
                    1,
                d = ({
                  long long TEMP;
                  cin >> TEMP;
                  TEMP;
                });
      v[c].push_back(d);
    }
    sort(v[0].begin(), v[0].end(), greater<long long>());
    sort(v[1].begin(), v[1].end(), greater<long long>());
    sort(v[2].begin(), v[2].end(), greater<long long>());
    if (v[2].size() == 0) v[2].push_back(-1);
    if (v[1].size() == 0) v[1].push_back(-1);
    a.push_back({{v[2][0], v[1][0]}, v[0]});
  }
  ({
    if (DEBUGGER)
      ({
        if (DEBUGGER)
          cout << "dp(0, 1)"
               << " = " << dp(0, 1) << endl;
      });
    else
      cout << dp(0, 1) << endl;
  });
}
int main(void) {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int multipletest = 0;
  if (multipletest) {
    int tc;
    cin >> tc;
    while (tc--) solve();
  } else
    solve();
  return 0;
}
