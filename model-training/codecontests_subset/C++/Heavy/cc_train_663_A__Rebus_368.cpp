#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
ostream& operator<<(ostream& os, const pair<T, U>& _p) {
  return os << "(" << _p.first << "," << _p.second << ")";
}
template <typename T>
ostream& operator<<(ostream& os, const vector<T>& _V) {
  bool f = true;
  os << "[";
  for (auto v : _V) {
    os << (f ? "" : ",") << v;
    f = false;
  }
  return os << "]";
}
template <typename T>
ostream& operator<<(ostream& os, const set<T>& _S) {
  bool f = true;
  os << "(";
  for (auto s : _S) {
    os << (f ? "" : ",") << s;
    f = false;
  }
  return os << ")";
}
template <typename T, typename U>
ostream& operator<<(ostream& os, const map<T, U>& _M) {
  return os << set<pair<T, U>>(_M.begin(), _M.end());
}
const signed long long INF = 1000000100;
const long double EPS = 1e-9;
vector<bool> pieprzo;
int xs[123];
int LAST;
int N = 0;
string YES = "Possible";
string NO = "Impossible";
void read_data() {
  string s;
  bool positive = true;
  while (true) {
    cin >> s;
    if (s == "?") {
      pieprzo.push_back(positive);
      ++N;
    }
    if (s == "+") positive = true;
    if (s == "-") positive = false;
    if (s == "=") {
      cin >> LAST;
      break;
    }
  }
}
void solve() {
  int MAX = LAST;
  int min_sum = 0;
  int max_sum = 0;
  for (int(i) = (0); (i) < (N); (i)++) {
    min_sum += pieprzo[i] ? 1 : -MAX;
    max_sum += pieprzo[i] ? MAX : -1;
  }
  if (!(min_sum <= LAST and LAST <= max_sum)) {
    cout << NO << endl;
    return;
  }
  int sum = 0;
  for (int(i) = (0); (i) < (N); (i)++) {
    xs[i] = 1;
    sum += pieprzo[i] ? 1 : -1;
  }
  for (int(i) = (0); (i) < (N); (i)++) {
    while (sum < LAST and pieprzo[i] and xs[i] != MAX) {
      ++xs[i];
      ++sum;
    }
    while (sum > LAST and !pieprzo[i] and xs[i] != MAX) {
      ++xs[i];
      --sum;
    }
  }
  cout << YES << endl;
  for (int(i) = (0); (i) < (N); (i)++) {
    if (i == 0) cout << xs[i] << " ";
    if (i != 0) cout << (pieprzo[i] ? " + " : " - ") << xs[i];
  }
  cout << " = " << LAST << endl;
}
int main() {
  read_data();
  solve();
}
