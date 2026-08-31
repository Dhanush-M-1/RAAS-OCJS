#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9 + 7;
const int mod = INF;
const int N = 1e6 + 7;
const int T = 1 << 20;
void solve() {
  vector<string> wyrazy;
  string temp;
  while (cin >> temp) {
    wyrazy.push_back(temp);
  }
  int n = stoi(wyrazy.back());
  vector<int> tab((int)wyrazy.size());
  int suma = 0;
  tab[0] = n;
  for (int i = 2; i < (int)wyrazy.size() - 2; i += 2) {
    assert(wyrazy[i] == "?");
    tab[i] = (wyrazy[i - 1] == "+" ? n : -1);
    suma += tab[i];
  }
  for (int i = 0; i < (int)wyrazy.size() - 2; i += 2) {
    while (tab[i] > 1 and suma > 0) {
      tab[i]--;
      suma--;
    }
    while (tab[i] > -n and tab[i] < 0 and suma > 0) {
      tab[i]--;
      suma--;
    }
  }
  if (suma != 0) {
    cout << "Impossible\n";
    exit(0);
  }
  cout << "Possible\n";
  for (int i = 0; i < (int)wyrazy.size(); i++) {
    if (wyrazy[i] == "?")
      cout << abs(tab[i]) << ' ';
    else
      cout << wyrazy[i] << ' ';
  }
  cout << '\n';
}
signed main() {
  int test = 1;
  for (int i = 0; i < test; i++) solve();
}
