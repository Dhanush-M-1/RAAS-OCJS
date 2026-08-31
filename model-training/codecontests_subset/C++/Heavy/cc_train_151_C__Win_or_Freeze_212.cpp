#include <bits/stdc++.h>
using namespace std;
template <typename T>
string tostr(const T& t) {
  ostringstream os;
  os << t;
  return os.str();
}
long long N;
vector<long long> getfactors(long long n) {
  set<long long> s;
  for (long long i = 1; i * i <= n; ++i) {
    if ((n % i) == 0) {
      if (i != 1 && i != n) s.insert(i);
      long long x = n / i;
      if (x != 1 && x != n) s.insert(x);
    }
  }
  return vector<long long>((s).begin(), (s).end());
}
map<long long, bool> memo;
bool go(int x) {
  vector<long long> f = getfactors(x);
  if ((int)f.size() == 0) {
    return true;
  }
  bool& ref = memo[x];
  bool allWin = true;
  for (int i = (int)(0); i <= (int)((int)f.size() - 1); ++i) {
    bool win = go(f[i]);
    if (!win) {
      allWin = false;
    }
  }
  if (allWin)
    ref = false;
  else
    ref = true;
  return ref;
}
int main() {
  cin >> N;
  vector<long long> f = getfactors(N);
  if ((int)f.size() == 0) {
    cout << "1" << endl;
    cout << "0" << endl;
  } else {
    bool found = false;
    for (int i = (int)(0); i <= (int)((int)f.size() - 1); ++i) {
      memo.clear();
      bool lose = !go(f[i]);
      if (lose) {
        found = true;
        cout << "1" << endl;
        cout << f[i] << endl;
        break;
      }
    }
    if (!found) cout << "2" << endl;
  }
  return 0;
}
