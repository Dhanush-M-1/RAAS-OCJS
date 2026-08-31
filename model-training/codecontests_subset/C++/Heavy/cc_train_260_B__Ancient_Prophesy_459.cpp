#include <bits/stdc++.h>
namespace patch {
template <typename T>
std::string to_string(const T& n) {
  std::ostringstream stm;
  stm << n;
  return stm.str();
}
}  // namespace patch
using namespace std;
long long int days[13] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
map<string, long long int> mp;
bool chk(char a) { return (a >= '0' && a <= '9'); }
void solve(string S) {
  if (S[2] == '-' && S[5] == S[2] && chk(S[0]) && chk(S[1]) && chk(S[3]) &&
      chk(S[4]) && chk(S[6]) && chk(S[7]) && chk(S[8]) && chk(S[9])) {
    stringstream ss;
    ss << S;
    long long int D = 0, M = 0, Y = 0;
    ss >> D >> M >> Y;
    D = abs(D);
    M = abs(M);
    Y = abs(Y);
    if (D == 0 || D > 31 || M == 0 || M > 12 || Y < 2013 || Y > 2015) {
      return;
    }
    if (D > 0 && D <= days[M - 1]) {
      mp[S]++;
    }
  }
}
int main() {
  string S;
  cin >> S;
  for (int i = 0; i < S.size() - 9; i++) {
    string tmp = "";
    for (int j = i; j < i + 10; j++) {
      tmp += S[j];
    }
    solve(tmp);
  }
  long long int mx = 0;
  string tmp;
  for (auto it : mp) {
    if (mx < it.second) {
      mx = it.second;
      tmp = it.first;
    }
  }
  stringstream ss;
  long long int X;
  ss << tmp;
  ss >> X;
  X = abs(X);
  if (X < 10) {
    cout << 0;
  }
  cout << X << '-';
  ss >> X;
  X = abs(X);
  if (X < 10) {
    cout << 0;
  }
  cout << X << '-';
  ss >> X;
  cout << abs(X);
  return 0;
}
