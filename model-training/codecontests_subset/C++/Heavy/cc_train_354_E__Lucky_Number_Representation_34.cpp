#include <bits/stdc++.h>
using namespace std;
const int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
const double EPS = 1e-8;
const double PI = acos(-1.0);
int popcount(int n) { return __builtin_popcount(n); }
int popcount(long long n) { return __builtin_popcountll(n); }
template <class T>
int SIZE(T a) {
  return a.size();
}
template <class T>
string IntToString(T num) {
  string res;
  stringstream ss;
  ss << num;
  return ss.str();
}
template <class T>
T StringToInt(string str) {
  T res = 0;
  for (int i = 0; i < SIZE(str); i++) res = (res * 10 + str[i] - '0');
  return res;
}
template <class T>
T gcd(T a, T b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
template <class T>
T lcm(T a, T b) {
  return a / gcd(a, b) * b;
}
template <class T>
void PrintSeq(T &a, int sz) {
  for (int i = 0; i < sz; i++) {
    cout << a[i];
    if (sz == i + 1)
      cout << endl;
    else
      cout << ' ';
  }
}
long long getTen(int a) { return (a <= 0) ? 1 : (getTen(a - 1) * 10); }
bool EQ(double a, double b) { return abs(a - b) < EPS; }
void fastStream() {
  cin.tie(0);
  std::ios_base::sync_with_stdio(0);
}
vector<string> split(string str, char del) {
  vector<string> res;
  for (int i = 0, s = 0; i < SIZE(str); i++) {
    if (str[i] == del) {
      if (i - s != 0) res.push_back(str.substr(s, i - s));
      s = i + 1;
    } else if (i == SIZE(str) - 1) {
      res.push_back(str.substr(s));
    }
  }
  return res;
}
int T;
bool isMade[101];
vector<int> M[101];
void dfs(int num, int depth, int ary[], int sz) {
  if (depth == 6) {
    if (!isMade[num]) {
      isMade[num] = true;
      for (int i = 0; i < 6; i++) M[num].push_back(ary[i]);
    }
  } else {
    ary[sz] = 4;
    dfs(num + 4, depth + 1, ary, sz + 1);
    ary[sz] = 7;
    dfs(num + 7, depth + 1, ary, sz + 1);
    ary[sz] = 0;
    dfs(num + 0, depth + 1, ary, sz + 1);
  }
}
int dp[20][10];
vector<long long> rec(string &s) {
  vector<long long> res(6);
  int i = 0;
  int j = 0;
  long long p = 1;
  while (i != (int)s.size()) {
    for (int k = 0; k < 50; k++) {
      if (isMade[k]) {
        int c = (k + j) / 10;
        int m = (k + j) % 10;
        if (m == s[i] - '0' && dp[i + 1][c]) {
          i = i + 1;
          j = c;
          for (int l = 0; l < 6; l++) {
            res[l] += (M[k][l]) * p;
          }
          p *= 10;
          break;
        }
      }
    }
  }
  return res;
}
int main() {
  int ary[10];
  dfs(0, 0, ary, 0);
  cin >> T;
  while (T--) {
    long long N;
    cin >> N;
    string s = IntToString<long long>(N);
    reverse(s.begin(), s.end());
    for (int i = (int)s.size(); i >= 0; i--) {
      for (int j = 0; j < 10; j++) {
        int res = 0;
        if (i == (int)s.size()) {
          if (j == 0) res = true;
        } else {
          for (int k = 0; k < 50; k++) {
            if (isMade[k]) {
              int c = (k + j) / 10;
              int m = (k + j) % 10;
              if (m == s[i] - '0') res |= dp[i + 1][c];
            }
          }
        }
        dp[i][j] = res;
      }
    }
    if (!dp[0][0])
      cout << -1 << endl;
    else {
      vector<long long> res = rec(s);
      for (int i = 0; i < 6; i++) {
        cout << res[i] << " ";
      }
      cout << endl;
    }
  }
  return 0;
}
