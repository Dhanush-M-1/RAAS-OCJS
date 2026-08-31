#include <bits/stdc++.h>
using namespace std;
void showlist(list<long long int> g) {
  list<long long int>::iterator it;
  for (it = g.begin(); it != g.end(); ++it) cout << *it << " ";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int t;
  cin >> t;
  while (t--) {
    long long int n{}, m{}, k{};
    cin >> n;
    vector<long long int> v(n);
    for (long long int i = 0; i < (n); i++) cin >> v.at(i);
    long long int r{};
    for (long long int i = 0; i < (n - 1); i++) {
      if ((v[i] + v[i + 1]) <= v[v.size() - 1]) {
        cout << i + 1 << " " << i + 2 << " " << n << ("\n");
        r = 1;
        break;
      }
    }
    if (r == 0) cout << -1 << ("\n");
  }
}
