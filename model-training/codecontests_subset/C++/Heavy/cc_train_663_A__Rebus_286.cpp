#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000000 + 7;
int addm(int& a, int b) { return (a += b) < mod ? a : a -= mod; }
template <class T, class U>
bool smin(T& a, U b) {
  return a > b ? (a = b, 1) : 0;
}
template <class T, class U>
bool smax(T& a, U b) {
  return a < b ? (a = b, 1) : 0;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  vector<char> sgns{'+'};
  int n;
  char cc;
  cin >> cc;
  long long st = 1;
  while (cin >> cc && cc != '=') {
    sgns.push_back(cc);
    if (cc == '-')
      st--;
    else
      st++;
    cin >> cc;
  }
  cin >> n;
  vector<int> sol(sgns.size(), 1);
  for (int i = 0; i < sgns.size(); i++) {
    if (st > n && sgns[i] == '-') {
      if (st - n > n - 1) {
        sol[i] = n;
        st -= n - 1;
      } else {
        sol[i] += st - n;
        st = n;
      }
    }
    if (st < n && sgns[i] == '+') {
      if (n - st > n - 1) {
        sol[i] = n;
        st += n - 1;
      } else {
        sol[i] += n - st;
        st = n;
      }
    }
  }
  if (st == n) {
    cout << "Possible\n";
    cout << sol[0];
    for (int i = 1; i < sgns.size(); i++) {
      cout << ' ' << sgns[i] << ' ' << sol[i];
    }
    cout << " = " << n << endl;
  } else
    cout << "Impossible\n";
}
