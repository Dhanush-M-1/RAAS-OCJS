#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
const long long INF = std::numeric_limits<long long>::max();
const int MX = 100101;
const long double PI =
    3.14159265358979323846264338327950288419716939937510582097494L;
template <typename T>
pair<T, T> operator+(const pair<T, T> &a, const pair<T, T> &b) {
  return pair<T, T>(a.first + b.first, a.second + b.second);
}
template <typename T>
pair<T, T> operator-(const pair<T, T> &a, const pair<T, T> &b) {
  return pair<T, T>(a.first - b.first, a.second - b.second);
}
template <typename T>
T operator*(const pair<T, T> &a, const pair<T, T> &b) {
  return (a.first * b.first + a.second * b.second);
}
template <typename T>
T operator^(const pair<T, T> &a, const pair<T, T> &b) {
  return (a.first * b.second - a.second * b.first);
}
template <typename T>
void print(vector<T> vec, string name = "") {
  cout << name;
  for (auto u : vec) cout << u << ' ';
  cout << '\n';
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int N;
  cin >> N;
  vector<pair<int, int>> sk(N);
  vector<vector<pair<int, int>>> X(MX), Y(MX);
  vector<unordered_set<int>> exists(MX);
  for (int i = 0; i < N; ++i) {
    cin >> sk[i].first >> sk[i].second;
    X[sk[i].first].emplace_back(sk[i].second, i);
    Y[sk[i].second].emplace_back(sk[i].first, i);
    exists[sk[i].first].insert(sk[i].second);
  }
  for (auto &&u : X) sort(u.begin(), u.end());
  for (auto &&u : Y) sort(u.begin(), u.end());
  vector<int> posX(N);
  vector<int> posY(N);
  for (auto &&mas : X) {
    for (int i = 0; i < (int)mas.size(); ++i) posX[mas[i].second] = i;
  }
  for (auto &&mas : Y) {
    for (int i = 0; i < (int)mas.size(); ++i) posY[mas[i].second] = i;
  }
  int ats = 0;
  auto pridekLeft = [&](pair<int, int> prad, pair<int, int> left) -> void {
    int len = prad.first - left.first;
    ats += int(exists[prad.first].count(prad.second - len) +
                   exists[left.first].count(left.second - len) ==
               2);
  };
  auto pridekDown = [&](pair<int, int> prad, pair<int, int> down) -> void {
    int len = prad.second - down.second;
    if (prad.first - len >= 0 and down.first - len >= 0)
      ats += int(exists[prad.first - len].count(prad.second) +
                     exists[down.first - len].count(down.second) ==
                 2);
  };
  for (int i = 0; i < N; ++i) {
    if (posX[i] < posY[i]) {
      for (int j = 0; j < posX[i]; ++j) {
        pridekDown(sk[i], {sk[i].first, X[sk[i].first][j].first});
      }
    } else {
      for (int j = 0; j < posY[i]; ++j) {
        pridekLeft(sk[i], {Y[sk[i].second][j].first, sk[i].second});
      }
    }
  }
  printf("%d\n", ats);
}
