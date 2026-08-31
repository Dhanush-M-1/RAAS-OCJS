#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:536870912")
const int MOD = 1000000007;
const int INF = 1000000001;
const int MAXN = 100010;
const long double EPS = 1e-6;
const int HASH_POW = 29;
const long double PI = acos(-1.0);
using namespace std;
void my_return(int code) { exit(code); }
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  mt19937 mt_rand(time(0));
  string s;
  map<int, string> foo;
  int cnt = 1, n;
  cin >> s;
  foo[cnt++] = "+";
  while (true) {
    cin >> s;
    if (s != "=") {
      foo[cnt++] = s;
      cin >> s;
    } else {
      cin >> n;
      break;
    }
  }
  --cnt;
  int cntplus = 0, cntminus = 0;
  for (map<int, string>::iterator it = foo.begin(); it != foo.end(); ++it)
    if (it->second == "+")
      ++cntplus;
    else
      ++cntminus;
  int ll1 = n - n * cntplus, rr1 = n - cntplus, ll2 = -n * cntminus,
      rr2 = -cntminus;
  if (min(rr1, rr2) < max(ll1, ll2)) {
    cout << "Impossible\n";
    my_return(0);
  }
  cout << "Possible\n";
  int valminus = -max(ll1, ll2), valplus = n + valminus;
  int baseminus = cntminus ? valminus / cntminus : 0,
      baseplus = cntplus ? valplus / cntplus : 0;
  int remminus = cntminus ? valminus % cntminus : 1,
      remplus = cntplus ? valplus % cntplus : 1;
  int deltaminus = 1, deltaplus = 1;
  if (remminus < 0) {
    remminus = -remminus;
    deltaminus = -deltaminus;
  }
  if (remplus < 0) {
    remplus = -remplus;
    deltaplus = -deltaplus;
  }
  for (int i = 1; i <= cnt; ++i) {
    if (i > 1) cout << " " << foo[i] << " ";
    if (foo[i] == "+") {
      if (remplus == 0) deltaplus = 0;
      cout << baseplus + deltaplus;
      --remplus;
    } else {
      if (remminus == 0) deltaminus = 0;
      cout << baseminus + deltaminus;
      --remminus;
    }
  }
  cout << " = " << n << endl;
  my_return(0);
}
