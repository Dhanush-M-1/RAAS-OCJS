#include <bits/stdc++.h>
using namespace std;
template <class T>
int size(const T &x) {
  return x.size();
}
const int INF = ~(1 << 31);
const double EPS = 1e-9;
const double pi = acos(-1);
template <class T>
T smod(T a, T b) {
  return (a % b + b) % b;
}
int main() {
  string s;
  cin >> s;
  int n;
  cin >> n;
  vector<string> words(n);
  for (decltype(0) i = (0); i < (n); ++i) cin >> words[i];
  bool flag = false;
  for (decltype(0) i = (0); i < (n); ++i)
    if (!flag)
      for (decltype(0) j = (0); j < (n); ++j) {
        string t = words[i] + words[j];
        if (t.find(s) != string::npos) {
          flag = true;
        }
      }
  cout << (flag ? "YES" : "NO") << endl;
  return 0;
}
