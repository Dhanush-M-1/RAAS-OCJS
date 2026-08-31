#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
int main() {
  ll n, i;
  cin >> n;
  string s;
  cin >> s;
  ll cnt = 0;
  for (ll i = (ll)0; i < (ll)n - 1; ++i) {
    if (s[i] > s[i + 1]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2 << endl;
      exit(0);
    }
  }
  cout << "NO" << endl;
}
