#include <bits/stdc++.h>
using namespace std;
vector<pair<string, string> > v;
string q, w, e, r, t, y, u;
long long int a, s, d, f, g, h;
int main() {
  cin >> e >> r >> a;
  for (int i = 0; i < a; i++) cin >> q >> w, v.push_back(make_pair(q, w));
  cout << e << " " << r << endl;
  for (int i = 0; i < a; i++) {
    if (v[i].first == e) e = v[i].second;
    if (v[i].first == r) r = v[i].second;
    cout << e << " " << r << endl;
  }
}
