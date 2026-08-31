#include <bits/stdc++.h>
using namespace std;
template <class T1, class T2>
ostream& operator<<(ostream& out, pair<T1, T2>& p) {
  out << p.first << ' ' << p.second;
}
template <class T>
istream& operator>>(istream& in, vector<T>& v) {
  for (auto& x : v) in >> x;
  return in;
}
template <class T>
ostream& operator<<(ostream& out, vector<T>& v) {
  for (auto x : v) out << x << ' ';
  return out;
}
int n;
bool A[5200][5200];
int dp[5200][5200], dp1[5200][5200];
vector<int> v;
string s;
int maxm = 1;
bool check(int x) {
  bool f = 0;
  for (long long i = (0); i < (n / x); ++i) {
    for (long long j = (0); j < (n / x); ++j) {
      if (dp[(i + 1) * x - 1][(j + 1) * x - 1] < x &&
          dp1[(i + 1) * x - 1][(j + 1) * x - 1] < x) {
        f = 1;
      }
    }
  }
  if (f) return 0;
  return 1;
}
int main() {
  iostream::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  cin >> n;
  for (long long i = (0); i < (n); ++i) {
    cin >> s;
    for (long long j = (0); j < ((int)s.size()); ++j) {
      int nm;
      if (s[j] >= 'A' && s[j] <= 'F')
        nm = 10 + (s[j] - 'A');
      else
        nm = s[j] - '0';
      while (nm > 0) {
        v.push_back(nm % 2);
        nm /= 2;
      }
      while ((int)v.size() < 4) v.push_back(0);
      reverse((v).begin(), (v).end());
      int cnt = 0;
      for (long long k = (0); k < (4); ++k) {
        A[i][j * 4 + cnt] = v[cnt];
        cnt++;
      }
      v.clear();
    }
  }
  for (long long i = (0); i < (n); ++i) {
    dp[0][i] = A[0][i];
    dp1[0][i] = 1 - A[0][i];
  }
  for (long long i = (0); i < (n); ++i) {
    dp[i][0] = A[i][0];
    dp1[i][0] = 1 - A[i][0];
  }
  for (long long i = (1); i < (n); ++i) {
    for (long long j = (1); j < (n); ++j) {
      if (A[i][j] == 1) {
        dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
      } else
        dp1[i][j] =
            min(min(dp1[i - 1][j], dp1[i][j - 1]), dp1[i - 1][j - 1]) + 1;
    }
  }
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      if (check(i)) maxm = max(maxm, i);
      if (i * i != n)
        if (check(n / i)) maxm = max(maxm, n / i);
    }
  }
  cout << maxm << "\n";
}
