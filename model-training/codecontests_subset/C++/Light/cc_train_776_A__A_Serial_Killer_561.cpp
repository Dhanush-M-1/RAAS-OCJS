#include <bits/stdc++.h>
using namespace std;
vector<long long> vi[200005];
vector<pair<long long, long long> > vii[200005];
int main() {
  string a, b;
  cin >> a >> b;
  cout << a << " " << b << endl;
  int n;
  cin >> n;
  while (n--) {
    string c, d;
    cin >> c >> d;
    if (a == c) {
      cout << b << " " << d << endl;
      ;
      a = d;
    } else {
      cout << a << " " << d << endl;
      b = d;
    }
  }
}
