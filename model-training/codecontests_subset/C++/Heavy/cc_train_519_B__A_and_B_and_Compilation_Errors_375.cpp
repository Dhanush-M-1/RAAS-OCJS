#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long n, aux, e;
  cin >> n;
  map<long, pair<int, int> > errors;
  for (long i = 0; i < n; ++i) {
    cin >> aux;
    errors[aux].first += 1;
    errors[aux].second += 1;
  }
  for (long i = 0; i < n - 1; ++i) {
    cin >> aux;
    errors[aux].first -= 1;
  }
  for (auto it = errors.begin(); it != errors.end(); ++it)
    if ((it->second).first) {
      cout << it->first;
      it->second.second -= 1;
      break;
    }
  for (long i = 0; i < n - 2; ++i) {
    cin >> aux;
    errors[aux].second -= 1;
  }
  for (auto it = errors.begin(); it != errors.end(); ++it)
    if ((it->second).second) {
      cout << '\n' << it->first;
      break;
    }
  return 0;
}
