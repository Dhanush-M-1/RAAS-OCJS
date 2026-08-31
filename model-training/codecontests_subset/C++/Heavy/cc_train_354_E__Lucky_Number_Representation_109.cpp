#include <bits/stdc++.h>
const long long INF = 4e18L + 1;
const int IINF = 2e9 + 1;
const int limit = 1048576;
using namespace std;
bool get_sol(
    long long carry, long long ans, long long ten_pow,
    const vector<pair<long long, long long> >& pos,
    map<pair<pair<long long, long long>, long long>, vector<long long> >& acc) {
  if (acc.count({{carry, ans}, ten_pow})) return true;
  long long target = 10 * carry + ans / ten_pow;
  if (ten_pow == 1) {
    if (pos[target] != make_pair(-1ll, -1ll)) {
      vector<long long> sol(6);
      for (int j = (int)0; j < (int)pos[target].first; j++) sol[j] = 4;
      for (int j = (int)pos[target].first;
           j < (int)pos[target].first + pos[target].second; j++)
        sol[j] = 7;
      acc[{{carry, ans}, ten_pow}] = sol;
      return true;
    }
  } else
    for (int i = (int)0; i < (int)5; i++)
      if (get_sol(i, ans % ten_pow, ten_pow / 10, pos, acc))
        if (target >= i and pos[target - i] != make_pair(-1ll, -1ll)) {
          vector<long long> sol = acc[{{i, ans % ten_pow}, ten_pow / 10}];
          for (int j = (int)0; j < (int)pos[target - i].first; j++)
            sol[j] += ten_pow * 4;
          for (int j = (int)pos[target - i].first;
               j < (int)pos[target - i].first + pos[target - i].second; j++)
            sol[j] += ten_pow * 7;
          acc[{{carry, ans}, ten_pow}] = sol;
          return true;
        }
  return false;
}
int main() {
  ios_base::sync_with_stdio(0);
  vector<pair<long long, long long> > pos(102, {-1, -1});
  for (int i = (int)0; i < (int)7; i++)
    for (int j = (int)0; j < (int)7 - i; j++) pos[4 * i + 7 * j] = {i, j};
  long long t;
  cin >> t;
  map<pair<pair<long long, long long>, long long>, vector<long long> > acc;
  for (int j = (int)1; j < (int)t + 1; j++) {
    long long n;
    cin >> n;
    long long ten_pow = 1;
    while (10 <= n / ten_pow) ten_pow *= 10;
    vector<long long> sol(6);
    if (get_sol(0, n, ten_pow, pos, acc)) {
      for (auto i : acc[{{0, n}, ten_pow}]) cout << i << " ";
      cout << "\n";
    } else
      cout << "-1\n";
  }
  return 0;
}
