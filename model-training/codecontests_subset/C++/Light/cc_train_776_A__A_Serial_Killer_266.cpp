#include <bits/stdc++.h>
using namespace std;
const int Maxn = 1e3 + 10;
int n;
string s, t;
int main() {
  cin >> s >> t;
  cout << s << " " << t << endl;
  cin >> n;
  for (int i = 0; i < n; i++) {
    string del, ne;
    cin >> del >> ne;
    if (del == t)
      t = ne;
    else
      s = ne;
    cout << s << " " << t << endl;
  }
}
