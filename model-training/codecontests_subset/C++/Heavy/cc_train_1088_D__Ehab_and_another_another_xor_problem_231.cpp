#include <bits/stdc++.h>
using namespace std;
vector<string> vec_splitter(string s) {
  for (char& c : s) c = c == ',' ? ' ' : c;
  stringstream ss;
  ss << s;
  vector<string> res;
  for (string z; ss >> z; res.push_back(z))
    ;
  return res;
}
void debug_out(vector<string> args, int idx) { cerr << endl; }
template <typename Head, typename... Tail>
void debug_out(vector<string> args, int idx, Head H, Tail... T) {
  if (idx > 0) cerr << ", ";
  stringstream ss;
  ss << H;
  cerr << args[idx] << " = " << ss.str();
  debug_out(args, idx + 1, T...);
}
void localTest() {}
map<pair<long long, long long>, long long> dp;
long long query(long long c, long long d) {
  if (dp.find({c, d}) != dp.end()) {
    return dp[{c, d}];
  }
  cout << "? " << c << " " << d << "\n";
  cout.flush();
  long long x;
  cin >> x;
  dp[{c, d}] = x;
  return x;
}
void solver() {
  long long N = 29;
  long long a = 0, b = 0, greater = query(0, 0);
  for (int i = N; i >= 0; --i) {
    long long bit = (1LL << i);
    long long fQuery = query(a ^ bit, b), sQuery = query(a, b ^ bit);
    if (fQuery == sQuery) {
      if (greater == 1) {
        a |= bit;
      } else {
        b |= bit;
      }
      greater = fQuery;
    } else if (sQuery == 1) {
      a |= bit;
      b |= bit;
    }
  }
  cout << "! " << a << " " << b << "\n";
  cout.flush();
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    solver();
  }
  return 0;
}
