#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
template <class L, class R>
ostream &operator<<(ostream &os, pair<L, R> P) {
  return os << "(" << P.first << "," << P.second << ")\n";
}
template <class T>
ostream &operator<<(ostream &os, set<T> V) {
  os << "[";
  for (auto vv : V) os << vv << ", ";
  return os << "\b\b]\n";
}
template <class T>
ostream &operator<<(ostream &os, vector<T> V) {
  for (auto vv : V) os << vv << ' ';
  return os << "\n";
}
template <class K, class X>
ostream &operator<<(ostream &os, map<K, X> V) {
  os << "[";
  for (auto vv : V) os << vv << ", ";
  return os << "\b\b]\n";
}
long long int ceildiv(long long int n, long long int f) {
  if (n % f) {
    return n / f + 1;
  } else
    return n / f;
}
int main() {
  int n;
  cin >> n;
  int pos;
  int time = 0;
  for (int i = 0; i < n; i++) {
    cin >> pos;
    int left = 1 + time, right = 1000000 - time;
    if (pos > left && pos < right) time += min(pos - left, right - pos);
  }
  cout << time << endl;
  return 0;
}
