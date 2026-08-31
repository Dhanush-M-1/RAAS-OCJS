#include <bits/stdc++.h>
using namespace std;
template <typename A, typename B>
ostream &operator<<(ostream &os, const pair<A, B> &p) {
  return os << "(" << p.first << " " << p.second << ")";
};
template <typename T>
ostream &operator<<(ostream &os, const vector<T> &vec) {
  os << "VECTOR: ";
  for (auto ele : vec) os << ele << " ";
  return os;
};
const int MAXN = 1e5;
const int mod = 1e9 + 7;
vector<vector<int>> table(10, vector<int>(10));
string toRadix(int n, int k) {
  string res;
  while (n > 0) {
    res = (char)(n % k + '0') + res;
    n /= k;
  }
  return res;
}
void prepare() {
  for (int i = 1; i < 10; i++) {
    for (int j = 1; j < 10; j++) {
      table[i][j] = i * j;
    }
  }
}
void solution() {
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      if (j == k - 1)
        cout << toRadix(table[i][j], k);
      else
        cout << toRadix(table[i][j], k) << " ";
    }
    cout << '\n';
  }
}
int main() {
  cin.tie(0);
  ios_base::sync_with_stdio(false);
  cout.tie(0);
  ;
  prepare();
  int test = 1;
  while (test--) solution();
  return 0;
}
