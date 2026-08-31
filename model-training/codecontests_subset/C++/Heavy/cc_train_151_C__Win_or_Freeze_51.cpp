#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > decomposition(long long int n) {
  vector<pair<int, int> > factors;
  for (long long int i = 2; i * i <= n; i++)
    if (n % i == 0) {
      int t = 0;
      while (n % i == 0) {
        n /= i;
        t++;
      }
      factors.push_back(pair<int, int>(i, t));
    }
  if (n != 1) factors.push_back(pair<int, int>(n, 1));
  return factors;
}
int main() {
  long long int n;
  cin >> n;
  vector<pair<int, int> > factors = decomposition(n);
  int s = factors.size();
  if (s == 0 || (s == 1 && factors[0].second == 1))
    cout << 1 << endl << 0 << endl;
  else if ((s == 1 && factors[0].second == 2) ||
           (s == 2 && factors[0].second == 1 && factors[1].second == 1))
    cout << 2 << endl;
  else
    cout << 1 << endl
         << ((factors[0].second == 1) ? factors[0].first * factors[1].first
                                      : factors[0].first * factors[0].first)
         << endl;
}
