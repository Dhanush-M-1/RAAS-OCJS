#include <bits/stdc++.h>
using namespace std;
template <class T1, class T2>
inline istream& operator>>(istream& fin, pair<T1, T2>& pr) {
  fin >> pr.first >> pr.second;
  return fin;
}
template <class T0, class T1, class T2>
inline istream& operator>>(istream& fin, tuple<T0, T1, T2>& t) {
  fin >> get<0>(t) >> get<1>(t) >> get<2>(t);
  return fin;
}
template <class T>
inline istream& operator>>(istream& fin, vector<T>& a) {
  if (!a.size()) {
    size_t n;
    fin >> n;
    a.resize(n);
  }
  for (auto& u : a) fin >> u;
  return fin;
}
const char* probA() {
  vector<string> grid(8);
  cin >> grid;
  string piece = "QRBNPK.";
  vector<int> score({9, 5, 3, 3, 1, 0, 0});
  map<char, int> w;
  for (size_t i = 0; i < 7; ++i) {
    w[piece[i]] = score[i];
    w[::tolower(piece[i])] = -score[i];
  };
  int val = 0;
  for (const auto& r : grid)
    for (const auto& x : r) val += w.at(x);
  return val < 0 ? "Black" : 0 < val ? "White" : "Draw";
}
void probB() {
  size_t n;
  cin >> n;
  vector<int> a(n);
  cin >> a;
  map<int, tuple<size_t, size_t, size_t> > m;
  for (const auto x : a) ++get<0>(m[x]);
  a.resize(n - 1);
  cin >> a;
  for (const auto x : a) ++get<1>(m[x]);
  for (const auto& pr : m)
    if (get<1>(pr.second) < get<0>(pr.second)) {
      cout << pr.first << '\n';
      break;
    }
  a.resize(n - 2);
  cin >> a;
  for (const auto x : a) ++get<2>(m[x]);
  for (const auto& pr : m)
    if (get<2>(pr.second) < get<1>(pr.second)) {
      cout << pr.first << '\n';
      break;
    }
}
int main(const int argc, char* argv[]) {
  probB();
  return EXIT_SUCCESS;
}
